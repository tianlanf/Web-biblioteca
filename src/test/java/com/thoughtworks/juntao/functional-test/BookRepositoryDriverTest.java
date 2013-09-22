import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookRepositoryDriverTest extends DriverTestUtils{
    @Test
    public void shouldShowBooksTable() throws Exception {
        driver.get(URL_HOME + "/viewAllBooks");
        WebElement table = driver.findElement(By.tagName("table"));
        assertThat(table,notNullValue());
    }

    //TODO:how to avoid the dependency
    @Test
    public void shouldShowHeadFirstJava() throws Exception {
        driver.get(URL_HOME + "/viewAllBooks");
        WebElement table = driver.findElement(By.tagName("table"));
        assertThat(table.getText(),containsString("Head First Java"));
    }
}
