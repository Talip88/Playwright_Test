import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import pages.AccountEntries;
import pages.AccountNavigationPage;

import java.util.Arrays;

public class _02_SignUp_Test extends _04_Playwright_Runner {

    @Test

    public void SignUpTest(){

        page.navigate("https://www.bestbuy.com/?intl=nosplash");


       // page.locator("button[data-lid='hdr_signin']").click();
       // page.locator(".create-account-btn").click();
       //accountNavigationPage.navigateTo("Create Account");
       // createAccountPage.createAccountPage();

        accountNavigationPage.navigateTo("Sign In");

        // ENUMLA KULLANIM ŞEKLİ
        accountNavigationPage.navigateToWithEnum(AccountEntries.CREATE_ACCOUNT);
        System.out.println();


    }
}
