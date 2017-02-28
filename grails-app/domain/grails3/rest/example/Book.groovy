package grails3.rest.example

import grails.rest.Resource

@Resource(uri="/books", formats = ['json'])
class Book {

    String title

    static constraints = {
        title nullable: false, blank: false
    }
}
