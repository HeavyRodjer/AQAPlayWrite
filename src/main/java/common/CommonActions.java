package common;

import com.microsoft.playwright.*;

import static common.config.PLATFORM_AND_BROWSER;

public class CommonActions {

    public static Browser createDriver() {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false);

        Browser browser;
        switch (PLATFORM_AND_BROWSER) {
            case "Edge":
                browser = playwright.chromium().launch(options.setChannel("msedge"));
                break;
            case "Chrome":
                browser = playwright.chromium().launch(options.setChannel("chrome"));
                break;
            default:
                throw new IllegalArgumentException("INCORRECT BROWSER NAME: " + PLATFORM_AND_BROWSER);
        }
        return browser;
    }
}
