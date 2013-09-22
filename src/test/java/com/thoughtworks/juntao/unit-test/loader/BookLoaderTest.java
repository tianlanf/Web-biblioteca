package loader;

import com.thoughtworks.juntao.loader.BookLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
//TODO:bookLoader should return something when read file
public class BookLoaderTest {
    private File file;

    @Before
    public void setUp() {
        file = new File("books.txt");
        createTextFile(file);
    }

    @Test
    public void should_load_books_from_text_file() throws Exception {
        BookLoader bookLoader = new BookLoader();
        bookLoader.loadBooksByTextFile("books.txt");
        assertThat(bookLoader.getBookList().size(), is(2));
    }

    private void createTextFile(File file) {
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            writeBooksInTextFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeBooksInTextFile(File file) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter(file));
        output.write("Head First Java\n");
        output.write("Refactoring");
        output.close();
    }

    @After
    public void tearDown() throws Exception {
        file.delete();
    }
}
