import org.junit.jupiter.api.Test;
import pages.AccountEntries;
import pages.HomePage;

public class _07_SignInTest extends _05_Playwright_Runner_CustomAnnotation{

    @Test
    public void signInExistingUser(){
        homePage.navigate();
        accountNavigationPage.navigateToWithEnum(AccountEntries.SIGN_IN);
        signInPage.signIn(getProperty("email"), getProperty("password"));
        homePage.checkWeAreOnTheHomePage();


     }

    @Test
    public void signInExistingUser2(){
        homePage.navigate();
        accountNavigationPage.navigateToWithEnum(AccountEntries.SIGN_IN);
        signInPage.signIn(getProperty("email"), getProperty("password"));
        homePage.checkWeAreOnTheHomePage();


    }



}
