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
    }
    def destroy = {
    }
}
