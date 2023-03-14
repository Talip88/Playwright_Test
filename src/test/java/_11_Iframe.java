import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _11_Iframe {
    @Test
    public void Iframe(){
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();
        page.navigate("https://www.rediff.com");

        page.frameLocator("iframe[name='moneyiframe']").locator("#query").fill("Capital First Limited");
        Page popUp= page.waitForPopup(()-> {
            page.frameLocator("iframe[name='moneyiframe']").locator("input[type='submit']").click();
        });
        assertThat(popUp.locator("#queryTop")).containsText("Enter Company");
    }
}
