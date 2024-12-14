package tests.InfoboxTest.positive;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InfoboxPages.InfoboxStartMainPage;
import tests.base.BaseTest;

import static constans.Constans.Urls.INFOBOX_PAGE;

public class TestInfoboxPageStartMainPage extends BaseTest {

    static String chekPhoneNumberUser = "(95) 623 51 62";
    static String chekCodeNumberUser = "12345";

    @Test
    public void checkIsRedirectToAuth() {
        // Відкриваємо URL сторінки
        page.navigate(INFOBOX_PAGE);

        // Створюємо об'єкт сторінки InfoboxStartMainPage
        InfoboxStartMainPage infoboxStartMainPage = new InfoboxStartMainPage(page);

        // Вводимо номер телефону через метод сторінки
        infoboxStartMainPage.enterNumberInPhoneField("956235162");
        String actualPhoneNumber = infoboxStartMainPage.getPhoneFieldValue();
        Assertions.assertEquals(chekPhoneNumberUser, actualPhoneNumber, "Невідповідність номеру телефону!");

        // Натискаємо кнопку "Продовжити"
        infoboxStartMainPage.clickButtonContinueAuthorizationPage();

        // Вводимо код через метод сторінки
        infoboxStartMainPage.enterCodeInPhoneField("12345");
        String actualCodeNumber = infoboxStartMainPage.getCodeFieldValue();
        Assertions.assertEquals(chekCodeNumberUser, actualCodeNumber, "Невідповідність коду телефону!");
        // Натискаємо кнопку "Продовжити"
        infoboxStartMainPage.clickButtonContinueAuthorizationPage();
    }
}
