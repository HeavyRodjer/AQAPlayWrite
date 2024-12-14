package pages.base;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;

import static constans.Constans.TimeoutVeribles.EXPLICT_WAIT;

public class basePage {
    protected Page page;

    public basePage(Page page) {
        this.page = page;
    }

    // Очікування, щоб елемент став видимим
    public Locator waitElementIsVisible(Locator element) {
        element.waitFor(new Locator.WaitForOptions().setTimeout(EXPLICT_WAIT));
        return element;
    }
}
