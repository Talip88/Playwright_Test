import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _02_SignUp_Test extends _04_Playwright_Runner {

    @Test

    public void SignUpTest(){

        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        page.locator("button[data-lid='hdr_signin']").click();
        page.locator(".create-account-btn").click();
        page.locator("#firstName").fill("Talip");
        page.locator("#lastName").fill("COLAK");
        page.locator("#email").fill("espo@gmail.com");
        page.locator("input#fld-p1").fill("09137lqmdbnqlıdyqdqad.");
        page.locator("#reenterPassword").fill("09137lqmdbnqlıdyqdqad.");
        page.locator("#phone").fill("09137098979797");
        page.locator("input#is-recovery-phone").check();


    }
}
