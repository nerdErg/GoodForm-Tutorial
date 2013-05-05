package goodform.tutorial

import goodform.tutorial.pages.JobApplicationPage
import org.codehaus.groovy.grails.plugins.webdriver.WebDriverHelper
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * @author Ross Rowe
 */
class JobApplicationTests {
    @Rule
    public WebDriverHelper webdriver = new WebDriverHelper()

    private JobApplicationPage jobApplicationPage

    @Before
    public void openLoginPage() {
        jobApplicationPage = webdriver.open('jobApplicationForm', JobApplicationPage.class)
    }

    @Test
    public void testMandatoryFields() {
        jobApplicationPage.clickNewForm()
    }
}
