import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.*;
import pages.AccountNavigationPage;
import pages.Create_Account_Page;
import services.EnvironmentReaderService;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _04_Playwright_Runner {


    protected Page page;
    protected BrowserContext browserContext;
    protected Browser browser;
    protected static Playwright playwright;
    protected Create_Account_Page createAccountPage;
    protected AccountNavigationPage accountNavigationPage;

    @BeforeAll

    public static void init(){
        playwright=Playwright.create();
    }

    @BeforeEach
    public void setUp(){

        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext= browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        browserContext.setDefaultTimeout(40000);
        page=browserContext.newPage();
        createAccountPage=new Create_Account_Page(page);
        accountNavigationPage=new AccountNavigationPage(page);

    }
    @AfterEach
    public void tearDown(){
        browserContext.close();
        browser.close();
    }

    protected String getProperty(String key){
        return EnvironmentReaderService.getProperty(key);
  }
}

