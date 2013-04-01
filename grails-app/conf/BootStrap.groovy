import com.nerderg.goodForm.FormDefinition

class BootStrap {

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


        if (!FormDefinition.get(1)) {
            FormDefinition formDefinition = new FormDefinition(name: 'ContactDetails', formDefinition: sampleForm, formVersion: 1)
            formDefinition.save()
        }

        String jobApplicationDefinition = """
            form {
               question("Job1") {
                   "What is your name?" group: "names", {
                       "Title" text: 10, hint: "e.g. Mr, Mrs, Ms, Miss, Dr", suggest: "title"
                       "Given Names" text: 50, required: true
                       "Last or Family Name" text: 50, required: true
                       "Have you been or are you known by any other names?" hint: "e.g. maiden name, previous married name, alias, name at birth", {
                           "List your other names" listOf: "aliases", {
                               "Other name" text: 50
                               "Type of name" text: 40, hint: "e.g maiden name", suggest: "nameType"
                           }
                       }
                   }
               }
               question("Job2") {
                   "Contact details" group: "contact", {
                       "Home address" text: 200
                       "Postcode" number: 4, hint: "e.g. 2913"
                       "Home Phone" phone: 15
                       "Mobile Phone" phone: 15
                       "Work Phone" phone: 15
                   }
               }
               question("Job3") {
                  "Education" group: "education", {
                      "University" listOf: "universities", {
                          "Name" text: 20
                          "Years attended" text: 20
                          "Degree" text: 20
                          "Course" text: 20
                      }
                      "High School" listOf: "highSchools", {
                         "Name" text: 20
                         "Years attended" text: 20
                      }
                  }
               }

               //role applying for
               question("Job4") {
                    "Enter the details of the role you are applying for" group: "role", {
                          "Position" text: 50, required: true
                          "Company" text: 50, required: true
                    }
               }
               //include copy of resume
               question("Job5") {
                    "Resume" group: "resume", {
                        "Attach a copy of your resume" attachment: "resume_file"
                     }
               }
               //referee details
               question("Job6") {
                    "Enter details for two referees" group: "references", {
                          "Referee" listOf: "referee", {
                              "Given Names" text: 50, required: true
                              "Last or Family Name" text: 50, required: true
                              "Contact Phone" phone: 15, required: true
                          }

                    }
               }
        }"""
        if (!FormDefinition.get(2)) {
            FormDefinition formDefinition = new FormDefinition(name: 'JobApplication', formDefinition: jobApplicationDefinition, formVersion: 1)
            formDefinition.save()
        }
    }
    def destroy = {
    }
}
