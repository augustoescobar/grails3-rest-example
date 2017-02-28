package grails3.rest.example

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*

class BookController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    // GET /books
    @Secured(value=['permitAll'], httpMethod='GET')
    def index() {

        def user = this.getAuthenticatedUser()

        println "This is ${user.username}."

        def books = Book.findAll()

        render books as JSON
    }

    // GET /books/$id
    @Secured(value=['ROLE_ADMIN'], httpMethod='GET')
    def show(Book book) {
        render book as JSON
    }

    // POST /books
    @Secured(value=['ROLE_ADMIN'], httpMethod='POST')
    def save(Book book) {
        if (book == null) {
            render status: BAD_REQUEST
            return
        }

        if (book.hasErrors()) {
            render book.errors as JSON
            return
        }

        book.save flush:true

        render book as JSON
    }

    // PUT /books/$id
    @Secured(value=['ROLE_ADMIN'], httpMethod='PUT')
    def update(Book book) {
        if (book == null) {
            render status: NOT_FOUND
            return
        }

        if (book.hasErrors()) {
            render book.errors as JSON
            return
        }

        book.save flush:true

        render book as JSON
    }

    // DELETE /books/$id
    @Secured(value=['ROLE_ADMIN'], httpMethod='DELETE')
    def delete(Book book) {

        if (book == null) {
            render status: NOT_FOUND
            return
        }

        book.delete flush:true

        render status: OK
    }

    // GET /books/create
    // def create() { }

    // GET /books/$id/edit
    // def edit() { }
}
