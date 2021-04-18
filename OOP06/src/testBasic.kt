package com.lodny.oop

class Book {
    // property ( field, member variable ... )
    val publisher: String = "휴먼출판사"
    var title: String? = null

    // method
    fun showBook() {
        println("'${title ?: "no name"}' 책, $publisher 발행.")
    }
}

class KotlinBook(var title: String?, var author: String?) {
    // property ( field, member variable ... )
    val publisher: String = "휴먼출판사"

    // method
    fun showBook() {
        println("'${title ?: "no name"}' 책, ${author ?: "작자미상"} 지음, $publisher 발행.")
    }
}

fun testBasic() {
    println("> testBasic -----------------------------------------------")

    val myBook: Book = Book()       // constructor, make instance - no new, alloc ...

//    myBook.publisher = "xyz"    // err, val -> read only
    myBook.title = "코틀린의 등장"
    println("myBook = ${myBook} ${myBook.javaClass.name}")
    println("myBook.publisher = ${myBook.publisher}")
    println("myBook.title = ${myBook.title}")
    myBook.showBook()
    println()

    val koBook: KotlinBook = KotlinBook("코틀린의 등장", "홍길동")
    println("myBook = ${koBook} ${koBook.javaClass.name}")
    println("koBook.publisher = ${koBook.publisher}")
    println("koBook.title = ${koBook.title}")
    koBook.showBook()
    println()

    println("> testBasic -----------------------------------------------")
    println()
}
