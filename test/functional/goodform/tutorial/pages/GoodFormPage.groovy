package goodform.tutorial.pages

import org.codehaus.groovy.grails.plugins.webdriver.ButtonElement
import org.codehaus.groovy.grails.plugins.webdriver.LinkElement
import org.codehaus.groovy.grails.plugins.webdriver.WebDriverPage
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

/**
 * @author Ross Rowe
 */
class GoodFormPage extends WebDriverPage {

    LinkElement newFormLink

    ButtonElement submitButton

    List<WebElement> errors

    WebElement header

    LinkElement submitLink

    static elements = {
        newFormLink(By.linkText("New form"))
        submitLink(By.linkText("Submit Form"))
        submitButton(By.name("next"))
        errors(By.className("errors"))
        header(By.xpath("//h1"))
    }
}
