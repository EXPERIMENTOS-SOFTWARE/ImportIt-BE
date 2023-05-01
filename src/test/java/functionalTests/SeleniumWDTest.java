package functionalTests;

import java.time.Duration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class SeleniumWDTest {

    private WebDriver driver = null;

    @BeforeClass
    public void initDriver() throws MalformedURLException{
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWD\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }


    //TEST DE PRUEBA DONDE SE CONECTA A GOOGLE Y RETORNA EL TITULO DE LA PESTAÑA
    @Test
    public void testSearchOnGoogle() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Create a WebDriverWait instance with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Find the search box element
        WebElement searchBox = driver.findElement(By.name("q"));

        // Type in a search query
        searchBox.sendKeys("selenium webdriver");

        // Submit the search query
        searchBox.submit();

        // Wait for the search results to load
        wait.until(ExpectedConditions.titleContains("selenium webdriver"));

        // Print the title of the search results page
        System.out.println("Page title is: " + driver.getTitle());
    }


    @AfterClass
    public void tearDown(){
        // Quit the driver
        //driver.quit();
    }

}
