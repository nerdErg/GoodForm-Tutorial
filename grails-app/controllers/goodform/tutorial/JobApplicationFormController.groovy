package goodform.tutorial

import com.nerderg.goodForm.FormController
import com.nerderg.goodForm.FormInstance

class JobApplicationFormController extends FormController {

    def pdfRenderingService

    def createForm() {
        createForm('JobApplication')
    }

    @Override
    def submit(Long id) {

        FormInstance formInstance = formDataService.getFormInstance(id)
        Map formData = formInstance.storedFormData()
        File location = new File(grailsApplication.config.goodform.uploaded.file.location.toString() + '/form/' + id)
        location.mkdirs()
        File upload = new File(location, "applicationForm.pdf")
        upload.withOutputStream {outputStream ->
            pdfRenderingService.render([template: '/jobApplication/view', model: [formInstance: formInstance, formData: formData]], outputStream)
        }
        return super.submit(id)
    }
}
