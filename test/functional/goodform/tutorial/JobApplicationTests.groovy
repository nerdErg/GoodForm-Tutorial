package goodform.tutorial

import goodform.tutorial.pages.JobApplicationPage
import grails.util.BuildSettings
import org.codehaus.groovy.grails.plugins.webdriver.WebDriverHelper
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue

/**
 * @author Ross Rowe
 */
class JobApplicationTests {
    @Rule
    public WebDriverHelper webdriver = new WebDriverHelper()

    private JobApplicationPage jobApplicationPage

    @Before
    public void openCreateForm() {
        String userName = System.getenv("SAUCE_USER_NAME");
        String accessKey = System.getenv("SAUCE_API_KEY");
        String browserEnv = "iexplore" //System.getenv("SELENIUM_BROWSER");
        String versionEnv = "8"//System.getenv("SELENIUM_VERSION");
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
        System.setProperty(BuildSettings.FUNCTIONAL_BASE_URL_PROPERTY, "http://localhost:8080/GoodForm-Tutorial/jobApplicationForm")

        jobApplicationPage = webdriver.open('createForm', JobApplicationPage.class)
    }

    @Test
    public void testMandatoryFields() {
        jobApplicationPage.submitButton.click()
        assertFalse(jobApplicationPage.errors.isEmpty())
    }

    @Test
    public void successfulSubmission() {
        jobApplicationPage.givenName = "Joe"
        jobApplicationPage.lastName = "Tester"
        jobApplicationPage.submitButton.click()
        assertTrue(jobApplicationPage.errors.isEmpty())
        jobApplicationPage.jobNumber = "1234"
        jobApplicationPage.position = "1234"
        jobApplicationPage.company = "1234"
        jobApplicationPage.refereeGivenName = "Joe"
        jobApplicationPage.refereeLastName = "Boss"
        jobApplicationPage.refereePhone = "0404123456"
        jobApplicationPage.submitButton.click()
        assertTrue(jobApplicationPage.errors.isEmpty())
    }
}
