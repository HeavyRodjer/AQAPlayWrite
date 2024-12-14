package common;

public class config {
    /**
     * Вибір браузера для тестування (доступні: "chrome", "msedge", "firefox", "webkit")
     */
    public static final String PLATFORM_AND_BROWSER = "Edge";

    /**
     * Чи очищати кукі в браузері після проходження тесту
     */
    public static final Boolean CLEAR_COOLIES = false;

    /**
     * Чи закривати браузер після проходження тесту
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;

    /**
     * Чи потрібно очистити скріншоти після тестів
     */
    public static final Boolean CLEAR_REPORTS_DIR = true;

    /**
     * Чи запускати браузер у headless режимі (true = без графічного інтерфейсу)
     */
    public static final Boolean HEADLESS_MODE = false;
}
