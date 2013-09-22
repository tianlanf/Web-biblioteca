package com.thoughtworks.juntao.controller;

import com.thoughtworks.juntao.loader.BookLoader;
import com.thoughtworks.juntao.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("viewAllBooks")
public class BookRepositoryController {


    private BookLoader bookLoader;
    private String bookFilePath;

    //TODO:should not init here
    public BookRepositoryController() {
        this.bookLoader = new BookLoader();

    }

    @RequestMapping(method = RequestMethod.GET)
    public String showAllBooks(ModelMap model) {
        if (bookFilePath == null) {
            this.bookFilePath = getClass().getClassLoader().getResource("Books.txt").getFile();
        }
        bookLoader.loadBooksByTextFile(bookFilePath);
        model.put("books", bookLoader.getBookList());
        return "bookRepository";
    }

    public void setBookLoader(BookLoader bookLoader) {
        this.bookLoader = bookLoader;
    }

    public void setBookFilePath(String bookFilePath) {
        this.bookFilePath = bookFilePath;
    }
}
