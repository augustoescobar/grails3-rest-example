import grails3.rest.example.Book

class BootStrap {

    def init = { servletContext ->
        new Book(title: "My Book").save()
    }
    def destroy = {
    }
}
