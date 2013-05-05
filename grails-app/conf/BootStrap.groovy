import com.nerderg.goodForm.FormDefinition

class BootStrap {

    def formDataService

    def init = { servletContext ->

        String sampleForm = """
            form {  //start with a 'form' element
               question("Q1") {   //include a 'question' element with an identifier
                   "What is your name?" group: "names", {
                       "Title" text: 10, hint: "e.g. Mr, Mrs, Ms, Miss, Dr", suggest: "title", map: 'title'
                       "Given Names" text: 50, required: true, map: 'givenNames'
                       "Last or Family Name" text: 50, required: true, map: 'lastName'
                       "Have you been or are you known by any other names?" hint: "e.g. maiden name, previous married name, alias, name at birth", map: 'hasAlias', {
                           "List your other names" listOf: "aliases", {
                               "Other name" text: 50, map: 'alias'
                               "Type of name" text: 40, hint: "e.g maiden name", suggest: "nameType", map: 'aliasType'
                           }
                       }
                   }
               }
               question("Q2") { //second question
                   "What is your favorite colour?" text: 20, suggest: "colour", map: 'faveColour'
               }
        }"""


        if (!FormDefinition.findByName('ContactDetails')) {
            formDataService.createNewFormVersion('ContactDetails', sampleForm)
        }

        String jobApplicationDefinition = """
            form {
               question("Job1") {
                   "What is your name?" group: "names", {
                       "Title" text: 10, hint: "e.g. Mr, Mrs, Ms, Miss, Dr", suggest: "title", map: "Title"
                       "Given Names" text: 50, required: true, map: "givenNames"
                       "Last or Family Name" text: 50, required: true, map: "lastName"
                       "Have you been or are you known by any other names?" hint: "e.g. maiden name, previous married name, alias, name at birth", map: "hasAlias", {
                           "List your other names" listOf: "aliases", {
                               "Other name" text: 50, map: 'alias'
                               "Type of name" text: 40, hint: "e.g maiden name", suggest: "nameType", map: 'aliasType'
                           }
                       }
                   }
               }
               question("Job2") {
                   "Contact details" group: "contact", {
                       "Home address" text: 200, map: 'homeAddress'
                       "Postcode" number: 4, hint: "e.g. 2913", map: 'postcode'
                       "Home Phone" phone: 15, map: 'homePhone'
                       "Mobile Phone" phone: 15, map: 'mobilePhone'
                       "Work Phone" phone: 15, map: 'workPhone'
                   }
               }
               question("Job3") {
                  "Education" group: "education", {
                      "University" listOf: "universities", {
                          "Name" text: 20, map: 'name'
                          "Years attended" text: 20, map: 'years'
                          "Degree" text: 20, map: 'degree'
                          "Course" text: 20, map: 'course'
                      }
                      "High School" listOf: "highSchools", {
                         "Name" text: 20, map: 'name'
                         "Years attended" text: 20, map: 'years'
                      }
                  }
               }

               //role applying for
               question("Job4") {
                    "Enter the details of the role you are applying for" group: "role", {
                          "Job Number" text: 50, required: true, map: 'jobNumber'
                          "Position" text: 50, required: true, map: 'position'
                          "Company" text: 50, required: true, map: 'company'
                    }
               }
               //include copy of resume
               question("Job5") {
                    "Resume" group: "resume", {
                        "Attach a copy of your resume" attachment: "resume_file", map: 'resume'
                     }
               }
               //referee details
               question("Job6") {
                    "Enter details for two referees" group: "references", {
                          "Referee" listOf: "referee", {
                              "Given Names" text: 50, required: true, map: 'givenNames'
                              "Last or Family Name" text: 50, required: true, map: 'lastName'
                              "Contact Phone" phone: 15, required: true, map: 'phone'
                          }

                    }
               }
        }"""

        if (!FormDefinition.findByName('JobApplication')) {
            formDataService.createNewFormVersion('JobApplication', jobApplicationDefinition)
        }
    }
    def destroy = {
    }
}
