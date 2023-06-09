import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _08_PopupTest {

    @Test
    public void popUpTest(){
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page=browser.newPage();

        page.navigate("http://Watir.com/examples/forms_with_input_elements.html");

        Page popUp= page.waitForPopup(()->{
            page.locator("#new_popup_window").click();
        });

        assertThat(popUp.locator("#axis_example")).containsText("Laurie");

        page.bringToFront(); //switch original page
        page.locator("#new_user_first_name").fill("playwright");

    }
}
