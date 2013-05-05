package goodform.tutorial.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
/**
 * @author Ross Rowe
 */
class ContactDetailsPage extends GoodFormPage {

    static expectedURL = ~".+contactDetailsForm.+"

    WebElement givenName

    WebElement lastName

    static elements = {
        givenName(By.id("Q1.names.givenNames"))
        lastName(By.id("Q1.names.lastName"))
    }

}
