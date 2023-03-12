import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _03_Assertions extends _04_Playwright_Runner{


    @Test
    public void Assertions(){

        page.navigate("https://www.bestbuy.com/?intl=nosplash");
        page.locator("button[data-lid='hdr_signin']").click();
        page.locator(".create-account-btn").click();

        page.locator("#firstName").fill("Talip");
        page.locator("#lastName").fill("COLAK");
        page.locator("#email").fill("espo@gmail.com");
        page.locator("input#fld-p1").fill("09137lqmdbnqlıdyqdqad.");
        page.locator("#reenterPassword").fill("09137lqmdbnqlıdyqdqad.");

        assertThat(page.locator("span.c-input-error-message")).containsText("Your passwords match!",
                new LocatorAssertions.ContainsTextOptions().setTimeout(30000));

        page.locator("#phone").fill("09137098979797");
        page.locator("input#is-recovery-phone").check();

        assertThat(page.locator("button.cia-form__control__submit")).isEnabled(new LocatorAssertions.IsEnabledOptions().setTimeout(10000));

    }
}
