package goodform.tutorial.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

/**
 * @author Ross Rowe
 */
class JobApplicationPage extends GoodFormPage {

    static expectedURL = ~".+jobApplicationForm.+"

    WebElement givenName

    WebElement lastName
    WebElement jobNumber
    WebElement position
    WebElement company
    WebElement refereeGivenName
    WebElement refereeLastName
    WebElement refereePhone

    static elements = {
        givenName(By.id("Job1.names.givenNames"))
        lastName(By.id("Job1.names.lastName"))
        jobNumber(By.id("Job4.role.jobNumber"))
        position(By.id("Job4.role.position"))
        company(By.id("Job4.role.company"))
        refereeGivenName(By.id("Job6.references.referee.givenNames"))
        refereeLastName(By.id("Job6.references.referee.givenNames"))
        refereePhone(By.id("Job6.references.referee.phone"))
    }


}
