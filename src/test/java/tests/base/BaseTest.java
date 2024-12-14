package tests.base;

import com.microsoft.playwright.*;
import common.CommonActions;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.InfoboxPages.InfoboxStartMainPage;
import pages.InfoboxPages.InfoboxSearchTask;
import pages.base.basePage;

import java.io.File;
import java.time.LocalTime;
import java.util.Objects;

import static common.config.*;

@Feature("Main Page")
@ExtendWith(Listener.class)
@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected basePage BasePage;
    protected pages.InfoboxPages.InfoboxStartMainPage InfoboxStartMainPage;
//    protected InfoboxQuitPage InfoboxQuitPage;
    protected pages.InfoboxPages.InfoboxSearchTask InfoboxSearchTask;
//    protected InfoboxCreationTask InfoboxCreationTask;
//    protected InfoboxFinalizationTask InfoboxFinalizationTask;

    private static final String COOKIE_FILE = "cookie/cookies.data";
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @BeforeAll
    void setup() {
        browser = CommonActions.createDriver();
        page = CommonActions.getPage(); // Отримуємо сторінку для тестування

        // Ініціалізація всіх сторінок
        BasePage = new basePage(page);
        InfoboxStartMainPage = new InfoboxStartMainPage(page);
//        InfoboxQuitPage = new InfoboxQuitPage(page);
        InfoboxSearchTask = new InfoboxSearchTask(page);
//        InfoboxCreationTask = new InfoboxCreationTask(page);
//        InfoboxFinalizationTask = new InfoboxFinalizationTask(page);

        LOGGER.info("START TIME:" + LocalTime.now());

        // Очистка алюрів
        LOGGER.info("START CLEAR REPORTS dir: screenshots/reports/tests");
        clearDirectory("allure-results");
        if (CLEAR_REPORTS_DIR) {
            clearDirectory("screenshots/reports/tests");
        }
    }

    private void clearDirectory(String dirPath) {
        File directory = new File(dirPath);
        if (directory.isDirectory()) {
            for (File item : Objects.requireNonNull(directory.listFiles())) {
                item.delete();
            }
        }
    }

    @AfterEach
    void clearCookiesAndLocalStorage() {
        if (CLEAR_COOLIES) {
            context.clearCookies();
            page.evaluate("window.sessionStorage.clear()");
        }
    }

//    @AfterAll
//    void teardown() {
//        if (!HOLD_BROWSER_OPEN) {
//            browser.close();
//        }
//        playwright.close();
//    }
}
