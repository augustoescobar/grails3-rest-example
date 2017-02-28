package grails3.rest.example

class Book {

    String title

    static constraints = {
        title nullable: false, blank: false
    }
}
