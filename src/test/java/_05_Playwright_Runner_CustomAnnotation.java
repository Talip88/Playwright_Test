import annotations.Playwright_Page;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AccountNavigationPage;
import pages.Create_Account_Page;
import pages.HomePage;
import pages.SignInPage;
import services.EnvironmentReaderService;

import javax.sql.rowset.BaseRowSet;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.Arrays;

   @ExtendWith(TestWatcherExtention.class)
   @TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class _05_Playwright_Runner_CustomAnnotation {


    protected Page page;
    protected BrowserContext browserContext;
    protected Browser browser;
    protected Playwright playwright;

    @Playwright_Page
    protected Create_Account_Page createAccountPage;

    @Playwright_Page
    protected AccountNavigationPage accountNavigationPage;

    @Playwright_Page
    protected HomePage homePage;

    @Playwright_Page
    protected SignInPage signInPage;




    @BeforeAll

    public  void init(){
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
        initPage(this, page);


    }

    private void initPage(Object object, Page page){

        Class <?> clazz= this.getClass().getSuperclass();

        for(Field field :clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(Playwright_Page.class)){
                Class<?> []type={Page.class};
                try{
                    field.set(this,field.getType().getConstructor(type).newInstance(page));
                }catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e){
                    System.out.println("Did not manage to call constructor for playwright page with name" +field.getName());
                }
            }
        }
        System.out.println();

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

