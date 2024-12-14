package tests.InfoboxTest.positive;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InfoboxPages.InfoboxSearchTask;
import tests.base.BaseTest;

import static constans.Constans.Urls.INFOBOX_PAGE;


public class TestInfoboxPageSearchTask extends BaseTest {
    static String  chekPhoneNumberUser = "(95) 623 51 62";
    static String  chekCodeNumberUser = "12345";
    static String  chekFinalizingValue= "На доопрацюванні" ;
    @Test
    public void checkIsRedirectToAuth()  {
        //Метод для підставляння силки ITSM_MAIN_URL - сама силка, яка знаходиться в константах
        page.navigate(INFOBOX_PAGE);
        InfoboxSearchTask InfoboxSearchTask = new InfoboxSearchTask(page);

        InfoboxSearchTask.enterNumberInPhoneField("956235162");
        String actualPhoneNumber = InfoboxSearchTask.getPhoneFieldValue();
        Assertions.assertEquals( chekPhoneNumberUser, actualPhoneNumber,"Невідповідність номеру телефону!");

        InfoboxSearchTask.clickButtonContinueAuthorizationPage();

        InfoboxSearchTask.enterCodeInPhoneField("12345");
        String actualCodeNumber = InfoboxSearchTask.getCodeFieldValue();
        Assertions.assertEquals( chekCodeNumberUser, actualCodeNumber,"Невідповідність коду телефону!");

        InfoboxSearchTask.clickButtonContinueAuthorizationPage();

        InfoboxSearchTask.clickButtonGoInMainPage();

        InfoboxSearchTask.clickButtonFinalizingInVacationPage();
        String actualFinalizingValue = InfoboxSearchTask.getFinalizingValue();
        Assertions.assertEquals( chekFinalizingValue, actualFinalizingValue,"Не знайдено відпустку в статусі доопарцювання!");
    }

}