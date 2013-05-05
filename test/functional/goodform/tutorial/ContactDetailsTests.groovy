package goodform.tutorial

import goodform.tutorial.pages.ContactDetailsPage
import grails.util.BuildSettings
import org.codehaus.groovy.grails.plugins.webdriver.WebDriverHelper
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

import static org.junit.Assert.*

/**
 * @author Ross Rowe
 */
class ContactDetailsTests {

    @Rule
    public WebDriverHelper webdriver = new WebDriverHelper()

    private ContactDetailsPage contactDetailsPage

    @Before
    public void openLoginPage() {

        String userName = System.getenv("SAUCE_USER_NAME");
        String accessKey = System.getenv("SAUCE_API_KEY");
        String browserEnv = "firefox" //System.getenv("SELENIUM_BROWSER");
        String versionEnv = "21"//System.getenv("SELENIUM_VERSION");
        String platformEnv = "windows XP"; //System.getenv("SELENIUM_PLATFORM");
        if (userName != null && accessKey != null && browserEnv != null && platformEnv != null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browserEnv);
            if (versionEnv) {
                capabilities.setCapability("version", versionEnv);
            }
            capabilities.setCapability("platform", platformEnv);
            webdriver.driver = new RemoteWebDriver(new URL("http://" + userName + ":" + accessKey + "@localhost:4445/wd/hub"), capabilities)
        }
        System.setProperty(BuildSettings.FUNCTIONAL_BASE_URL_PROPERTY, "http://localhost:8080/GoodForm-Tutorial/contactDetailsForm")
        contactDetailsPage = webdriver.open('createForm', ContactDetailsPage.class)
    }

    @Test
    public void testMandatoryFields() {
        contactDetailsPage.submitButton.click()
        assertFalse(contactDetailsPage.errors.isEmpty())
    }

    @Test
    public void successfulSubmission() {
        contactDetailsPage.givenName = "Joe"
        contactDetailsPage.lastName = "Tester"
        contactDetailsPage.submitButton.click()
        assertTrue(contactDetailsPage.errors.isEmpty())
        assertEquals(contactDetailsPage.header.webElement.getText(), "Form complete")
        contactDetailsPage.submitLink.click()
        assertEquals(contactDetailsPage.header.webElement.getText(), "Form submitted")
    }


}
