package pages.InfoboxPages;

import com.microsoft.playwright.Page;
import pages.base.basePage;


public class InfoboxSearchTask extends basePage {
    public InfoboxSearchTask(Page page) {
        super(page);
    }
    public final String PhoneFieldPanelAuthorizationPage = "//input[@type='tel' and @class='react-international-phone-input']";
    public final String buttonContinueAuthorizationPage = "//span[text()= 'Продовжити']";
    public final String CodeFieldPanelAuthorizationPage = "//input[@name='code' and @type='tel' and @placeholder='XXXXX']";
    public final String ButtonGoInMainPage = "//span[text() = 'Перейти']";
    public final String ButtonFinalizingInVacationPage = " (//span[text() = 'На доопрацюванні'])[1]";



    public InfoboxSearchTask enterNumberInPhoneField(String PhoneNumberUser){
        page.locator(PhoneFieldPanelAuthorizationPage).fill(PhoneNumberUser);
        return this;
    }
    public String getPhoneFieldValue() {
      return page.locator(PhoneFieldPanelAuthorizationPage).inputValue();
    }

    public InfoboxSearchTask clickButtonContinueAuthorizationPage(){
        page.locator(buttonContinueAuthorizationPage).click();
        return this;
    }
    public InfoboxSearchTask enterCodeInPhoneField(String PhoneCoderUser)  {
        page.locator(CodeFieldPanelAuthorizationPage).fill(PhoneCoderUser);
        return this;
    }
    public String getCodeFieldValue() {
        return page.locator(CodeFieldPanelAuthorizationPage).inputValue();
    }
    public InfoboxSearchTask clickButtonGoInMainPage(){
        page.locator(ButtonGoInMainPage).click();
        return this;
    }
    public InfoboxSearchTask clickButtonFinalizingInVacationPage(){
        page.locator(ButtonFinalizingInVacationPage).click();
        return this;
    }
    public String getFinalizingValue() {
        return page.locator(ButtonFinalizingInVacationPage).textContent();
    }

}
