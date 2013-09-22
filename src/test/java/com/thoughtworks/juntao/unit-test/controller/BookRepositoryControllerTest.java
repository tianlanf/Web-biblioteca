package controller;

import com.thoughtworks.juntao.controller.BookRepositoryController;
import com.thoughtworks.juntao.loader.BookLoader;
import com.thoughtworks.juntao.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class BookRepositoryControllerTest {
    @Mock
    BookLoader bookLoader;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldShowAllBooks() throws Exception {
        BookRepositoryController bookRepositoryController = new BookRepositoryController();
        bookRepositoryController.setBookLoader(bookLoader);
        bookRepositoryController.setBookFilePath("FileName.txt");

        List<Book> books = new ArrayList<Book>();
        when(bookLoader.getBookList()).thenReturn(books);

        ModelMap model = new ModelMap();
        String viewName = bookRepositoryController.showAllBooks(model);

        assertThat(viewName, is("bookRepository"));
        assertThat((List<Book>)model.get("books"), is(books));
    }
}
