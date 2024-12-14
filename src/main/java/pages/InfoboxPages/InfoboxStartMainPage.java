package pages.InfoboxPages;

import com.microsoft.playwright.Page;
import pages.base.basePage;

public class InfoboxStartMainPage extends basePage {
    public InfoboxStartMainPage(Page page) {
        super(page);
    }

    // Локатори
    public final String PhoneFieldPanelAuthorizationPage = "input[type='tel'].react-international-phone-input";
    public final String buttonContinueAuthorizationPage = "span:text('Продовжити')";
    public final String CodeFieldPanelAuthorizationPage = "input[name='code'][type='tel'][placeholder='XXXXX']";

    // Вводимо номер телефону в поле
    public InfoboxStartMainPage enterNumberInPhoneField(String PhoneNumberUser){
        page.locator(PhoneFieldPanelAuthorizationPage).fill(PhoneNumberUser);
        return this;
    }

    // Отримуємо значення з поля вводу телефону
    public String getPhoneFieldValue() {
        return page.locator(PhoneFieldPanelAuthorizationPage).inputValue();
    }

    // Натискаємо кнопку "Продовжити"
    public InfoboxStartMainPage clickButtonContinueAuthorizationPage(){
        page.locator(buttonContinueAuthorizationPage).click();
        return this;
    }

    // Вводимо код в поле
    public InfoboxStartMainPage enterCodeInPhoneField(String PhoneCoderUser) {
        page.locator(CodeFieldPanelAuthorizationPage).fill(PhoneCoderUser);
        System.out.println("Element found inside iframe with id: ");
        return this;
    }

    // Отримуємо значення з поля вводу коду
    public String getCodeFieldValue() {
        System.out.println("Element found inside iframe with id:2 ");
        return page.locator(CodeFieldPanelAuthorizationPage).inputValue();

    }
}
