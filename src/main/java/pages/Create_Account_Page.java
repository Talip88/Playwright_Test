package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Create_Account_Page {

    private final Page createAccountPage;
    private static final String FIRST_NAME="#firstName";
    private static final String LAST_NAME="#lastName";
    private static final String EMAIL="#email";
    private static final String PASSWORD="input#fld-p1";
    private static final String CONFIRM_PASSWORD="#reenterPassword";
    private static final String PHONE="#phone";
    private static final String RECOVERY_PHONE="input#is-recovery-phone";
    private static final String VALIDATION_MESSAGE="span.c-input-error-message";
    private static final String SUBMIT_BUTTON="button.cia-form__control__submit";


   public Create_Account_Page(Page page){
    this.createAccountPage=page;
   }

   public void createAccountPage(){

       createAccountPage.locator(FIRST_NAME).fill("Talip");
       createAccountPage.locator(LAST_NAME).fill("COLAK");
       createAccountPage.locator(EMAIL).fill("espo@gmail.com");
       createAccountPage.locator(PASSWORD).fill("09137lqmdbnqlıdyqdqad.");
       createAccountPage.locator(CONFIRM_PASSWORD).fill("09137lqmdbnqlıdyqdqad.");

       assertThat(createAccountPage.locator(VALIDATION_MESSAGE)).containsText("Your passwords match!",
               new LocatorAssertions.ContainsTextOptions().setTimeout(30000));

       createAccountPage.locator(PHONE).fill("09137098979797");
       createAccountPage.locator(RECOVERY_PHONE).check(new Locator.CheckOptions().setTimeout(30000)); //sadece bu işlem için timeout belirleme böyle olur

       assertThat(createAccountPage.locator(SUBMIT_BUTTON)).isEnabled(new LocatorAssertions.IsEnabledOptions().setTimeout(10000));



   }


}