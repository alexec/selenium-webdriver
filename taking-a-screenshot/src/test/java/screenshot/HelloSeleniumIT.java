package screenshot;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class HelloSeleniumIT {

    private final WebDriver driver = new FirefoxDriver();

    @Rule
    public TestRule screenshotTaker = new ScreenshotTaker((TakesScreenshot) driver);

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void homePageShowsHelloSelenium() throws Exception {

        driver.get("http://localhost:8080");

        WebElement heading = driver.findElement(By.cssSelector("h2"));

        assertTrue(heading.getText().contains("Hello Selenium!"));
    }
}
