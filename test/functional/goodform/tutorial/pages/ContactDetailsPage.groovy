package goodform.tutorial.pages

import org.codehaus.groovy.grails.plugins.webdriver.ButtonElement
import org.codehaus.groovy.grails.plugins.webdriver.LinkElement
import org.codehaus.groovy.grails.plugins.webdriver.WebDriverPage
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

/**
 * @author Ross Rowe
 */
class ContactDetailsPage extends WebDriverPage {

//    static expectedURL = ~".+contactDetailsForm"

    static expectedTitle = "Grails"

    LinkElement newFormLink

    ButtonElement submitButton

    List<WebElement> errors

    static elements = {
        newFormLink(By.linkText("New form"))
        submitButton(By.name("next"))
        errors(By.className("errors"))
    }

}
