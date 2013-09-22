package com.thoughtworks.juntao.loader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.juntao.model.Book;

public class BookLoader {
    private List<Book> bookList;

    public BookLoader() {
        bookList = new ArrayList<Book>();
    }

    public void loadBooksByTextFile(String filePath) {
        try {
            FileReader fileReader = new FileReader(new File(filePath));
            BufferedReader reader = new BufferedReader(fileReader);
            formBookList(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void formBookList(BufferedReader reader) {
        bookList = new ArrayList<Book>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                bookList.add(new Book(line));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }
}

