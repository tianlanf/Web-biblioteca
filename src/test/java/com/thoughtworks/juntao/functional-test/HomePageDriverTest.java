import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;


public class HomePageDriverTest extends DriverTestUtils {

    @Test
    public void shouldShowWelcomeMessage() throws Exception {
        driver.get(URL_HOME);
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        assertThat(welcomeMessage.getText(), is("Welcome to Juntao's library"));
    }

    @Test
    public void shouldShowViewAllBooksOption() throws Exception {
        driver.get(URL_HOME);
        WebElement viewAllBooks = driver.findElement(By.id("viewAllBooks"));
        assertThat(viewAllBooks, notNullValue());
    }

    @Test
    public void shouldLinkToViewAllBooks() throws Exception {
        driver.get(URL_HOME);
        driver.findElement(By.id("viewAllBooks")).click();
        assertThat(driver.getCurrentUrl(), is(URL_HOME + "/viewAllBooks"));
    }
}
