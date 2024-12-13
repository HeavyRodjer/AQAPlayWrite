package tests.base;

import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Listener implements TestWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        LOGGER.info("Test {} - Failed", context.getTestMethod().get().getName());

        // Отримання Page з BaseTest
        Page page = ((BaseTest) context.getRequiredTestInstance()).page;

        String screenshotName = context.getTestMethod().get().getName() +
                String.valueOf(System.currentTimeMillis()).substring(9, 13);

        LOGGER.info("Try to trace screenshot...");

        // Збереження скріншота локально
        Path screenshotPath = Paths.get("screenshots/reports/tests/" + screenshotName + ".png");
        try {
            Files.createDirectories(screenshotPath.getParent()); // Перевірка і створення директорій
            page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
        } catch (Exception e) {
            LOGGER.error("Exception on saving screenshot: ", e);
            throw new RuntimeException(e);
        }

        // Додавання скріншота в Allure
        attachScreenshotsToAllure(page);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshotsToAllure(Page page) {
        try {
            return page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
        } catch (Exception e) {
            LOGGER.error("Failed to attach screenshot to Allure: ", e);
            return new byte[0];
        }
    }
}
