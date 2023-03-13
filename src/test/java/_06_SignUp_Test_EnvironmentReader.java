import org.junit.jupiter.api.Test;
import pages.AccountEntries;
import services.EnvironmentReaderService;

public class _06_SignUp_Test_EnvironmentReader extends _04_Playwright_Runner {

    @Test

    public void SignUpTest(){

        page.navigate(getProperty("url"));
        accountNavigationPage.navigateTo("Sign In");

//        // ENUMLA KULLANIM ŞEKLİ
//        accountNavigationPage.navigateToWithEnum(AccountEntries.CREATE_ACCOUNT);
//        System.out.println();


    }
}
