import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.*;
import pages.Create_Account_Page;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class _04_Playwright_Runner {


    protected Page page;
    protected BrowserContext browserContext;
    protected Browser browser;
    protected static Playwright playwright;
    protected Create_Account_Page createAccountPage;


    @BeforeAll

    public static void init(){
        playwright=Playwright.create();
    }

    @BeforeEach
    public void setUp(){

        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext= browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));
        page=browserContext.newPage();

        createAccountPage=new Create_Account_Page(page);


    }
    @AfterEach
    public void tearDown(){
        browserContext.close();
        browser.close();
    }
}

