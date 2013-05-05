package goodform.tutorial.pages

import org.codehaus.groovy.grails.plugins.webdriver.WebDriverPage
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

/**
 * @author Ross Rowe
 */
class JobApplicationPage extends WebDriverPage {

    static expectedURL = ~".+contactDetailsForm"

    @FindBy(linkText = "New Form")
    WebElement newForm

    def clickNewForm() {
        newForm.click()
    }
}
