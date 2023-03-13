import com.microsoft.playwright.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Arrays;

public class _01_First_Test{

        @Test
        @Disabled
        public void FirstTest() {
           try(
               Playwright playwright=Playwright.create()) {
               BrowserType chrome=playwright.chromium();
               Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false));

               //BrowserContext context = browser.newContext();
               //POP UP KAPATMA-Cografya bilgisi isteyen bir pop up ı kapatmak için kullanıldı

               BrowserContext contextPopUp = browser.newContext(new Browser.NewContextOptions().setPermissions(Arrays.asList("geolocation")));

               Page page = contextPopUp.newPage();
               page.navigate("https://www.bestbuy.com/?intl=nosplash");

             //page.locator("//a[@data-lid='hdr_dotd']").click(); // XPATH İLE BULUNDU
              // page.locator("[data-lid=hdr_dotd]").click();    // CSSSELECTOR
             // Locator locator=page.locator("[data-lid=hdr_dotd]");
             // locator.click();
             // locator.hover();

/*********************************************************************************************************************** */
               // BİRDEN FAZLA ELEMENTİ YAZDIRMA
               Locator menuItems=page.locator("ul.bottom-nav-left li a");
               System.out.println(menuItems.allTextContents());
/*********************************************************************************************************************** */
               // BİRDEN FAZLA ELEMENTİ ALT ALTA YAZDIRMA
                for (int i=0; i<menuItems.count(); i++){
                    System.out.println(menuItems.nth(i).allTextContents());
                }
/*********************************************************************************************************************** */

               //Birden fazla elemanı olan listeden bir elemanı seçip tıklama
               page.locator("ul.bottom-nav-left li a",new Page.LocatorOptions().setHasText("Deal of the Day")).click();

/*********************************************************************************************************************** */
               page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
               browser.close();




            }
        }
}
