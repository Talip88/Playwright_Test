import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class _10_ShadowDOM {

    @Test
    public void shadowDOM() {
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("http://Watir.com/examples/shadow_dom.html");
        page.locator("input[type='text']").fill("playwright");
        //page.locator("//input[@type='text']").fill("playwright"); XPATH SHADOW DOMU BULAMAZ
        page.locator("input[type='checkbox']").check();
    }
}
