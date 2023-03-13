import com.microsoft.playwright.*;
import org.junit.jupiter.api.Test;
import pages.AccountEntries;
import pages.AccountNavigationPage;

import java.util.Arrays;

public class _02_SignUp_Test extends _05_Playwright_Runner_CustomAnnotation {

    @Test

    public void SignUpTest(){

        homePage.navigate();
        accountNavigationPage.navigateToWithEnum(AccountEntries.CREATE_ACCOUNT);
        createAccountPage.createAccountPage();


    }

    public void SignUpTest2(){

        homePage.navigate();
        accountNavigationPage.navigateToWithEnum(AccountEntries.CREATE_ACCOUNT);
        createAccountPage.createAccountPage();


    }


}
