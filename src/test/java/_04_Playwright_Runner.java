import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AccountNavigationPage;
import pages.Create_Account_Page;
import services.EnvironmentReaderService;

import java.nio.file.Paths;
import java.util.Arrays;

@ExtendWith(TestWatcherExtention.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

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
        browserContext= browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation"))
                .setRecordVideoDir(Paths.get("videos/"))
                .setRecordVideoSize(1920,1680)); // Testi videoya kaydetmek için
        browserContext.setDefaultTimeout(40000);

        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false)); // TRACE VİEWER

        page=browserContext.newPage();
        createAccountPage=new Create_Account_Page(page);
        accountNavigationPage=new AccountNavigationPage(page);

    }
    @AfterEach
    public void tearDown(TestInfo testInfo){
        browserContext.tracing().
                stop(new Tracing.StopOptions()
                        .setPath(Paths.get("traces/"+testInfo.getDisplayName()
                                .replace("()","")+ ".zip"))); // STOP THE TRACE VİEWER
        browserContext.close();
        browser.close();
    }

    protected String getProperty(String key){
        return EnvironmentReaderService.getProperty(key);
  }
}

