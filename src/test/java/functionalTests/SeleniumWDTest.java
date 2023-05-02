package functionalTests;

import java.time.Duration;

import java.sql.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SeleniumWDTest {

    private WebDriver driver = null;

    @BeforeClass
    public void initDriver() throws MalformedURLException{
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWD\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }


    //CREATE BUYER USER
    @Test
    public void test1() throws SQLException{
        driver.get("http://localhost:4200/welcome");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.name("buyer")).click();
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.id("mat-input-2")).sendKeys("12345678");
        driver.findElement(By.id("mat-input-3")).sendKeys("Comprador Joel");
        driver.findElement(By.id("mat-input-4")).sendKeys("Hombre");
        driver.findElement(By.id("mat-input-5")).sendKeys("27");
        driver.findElement(By.id("mat-input-6")).sendKeys("03");
        driver.findElement(By.id("mat-input-7")).sendKeys("2001");
        driver.findElement(By.id("mat-input-8")).sendKeys("comprador@gmail.com");
        driver.findElement(By.id("mat-input-9")).sendKeys("999888777");
        driver.findElement(By.id("mat-input-10")).sendKeys("Callao, Perú");
        driver.findElement(By.id("mat-input-11")).sendKeys("contraseña");
        driver.findElement(By.cssSelector(".ng-tns-c122-12 > .mat-form-field-flex")).click();
        driver.findElement(By.cssSelector(".mat-button-wrapper")).click();


        String dbUrl = "jdbc:postgresql://localhost:5432/importBack";
        String username = "postgres";
        String password = "admin";

        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY id DESC LIMIT 1");
        String field1 = null;
        String field2 = null;

        while (rs.next()) {
            field1 = rs.getString("dni");
            field2 = rs.getString("password");

            System.out.println(field1 + " " + field2);
        }

        assertEquals(field1, "12345678");
        assertEquals(field2, "contraseña");

        // Cierre de la conexión
        rs.close();
        stmt.close();
        conn.close();
    }

    //CREATE TRAVELER USER
    @Test
    public void test2() throws SQLException {
        driver.get("http://localhost:4200/welcome");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.name("traveler")).click();
        driver.findElement(By.linkText("Sign Up")).click();
        driver.findElement(By.id("mat-input-2")).sendKeys("87654321");
        driver.findElement(By.id("mat-input-3")).sendKeys("Viajador Mike");
        driver.findElement(By.id("mat-input-4")).sendKeys("Hombre");
        driver.findElement(By.id("mat-input-5")).sendKeys("15");
        driver.findElement(By.id("mat-input-6")).sendKeys("12");
        driver.findElement(By.id("mat-input-7")).sendKeys("1998");
        driver.findElement(By.id("mat-input-8")).sendKeys("viajador@gmail.com");
        driver.findElement(By.id("mat-input-9")).sendKeys("978876765");
        driver.findElement(By.id("mat-input-10")).sendKeys("California, Estados Unidos");
        driver.findElement(By.id("mat-input-11")).sendKeys("nuevacontraseña");
        driver.findElement(By.cssSelector(".ng-tns-c122-12 > .mat-form-field-flex")).click();
        driver.findElement(By.cssSelector(".mat-button-wrapper")).click();



        String dbUrl = "jdbc:postgresql://localhost:5432/importBack";
        String username = "postgres";
        String password = "admin";

        Connection conn = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users ORDER BY id DESC LIMIT 1");
        String field1 = null;
        String field2 = null;

        while (rs.next()) {
            field1 = rs.getString("dni");
            field2 = rs.getString("password");

            System.out.println(field1 + " " + field2);
        }

        assertEquals(field1, "87654321");
        assertEquals(field2, "nuevacontraseña");

        // Cierre de la conexión
        rs.close();
        stmt.close();
        conn.close();
    }


    //CREATE NEW ORDER
    @Test
    public void test3() {
        driver.get("http://localhost:4200/welcome");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.name("buyer")).click();
        driver.findElement(By.id("mat-input-0")).sendKeys("12345678");
        driver.findElement(By.id("mat-input-1")).sendKeys("contraseña");
        driver.findElement(By.cssSelector(".mat-button-wrapper")).click();
        // WAIT TO THE ALERT IS AVAILABLE
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        // CHANGE THE FOCUS
        Alert alert = driver.switchTo().alert();
        alert.accept();
        {
            WebElement element = driver.findElement(By.cssSelector(".mat-icon:nth-child(1)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".mat-icon:nth-child(1)")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".mat-list-item:nth-child(2) > .mat-list-item-content")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".mat-flat-button > .mat-button-wrapper"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".mat-flat-button > .mat-button-wrapper")).click();

        driver.findElement(By.name("url")).sendKeys("https://www.amazon.com/-/es/Gigabyte-ventiladores-WINDFORCE-GV-N407TGAMING-OC-12GD/dp/B0BRR2R8HH/?_encoding=UTF8&pd_rd_w=h5Vnq&content-id=amzn1.sym.10f16e90-d621-4a53-9c61-544e5c741acc&pf_rd_p=10f16e90-d621-4a53-9c61-544e5c741acc&pf_rd_r=6313EGFHQS8FKM8TS0MV&pd_rd_wg=9kBoV&pd_rd_r=9fab8e8b-606d-4613-891c-80de91e0248c&ref_=pd_gw_exports_top_sellers_unrec");
        driver.findElement(By.name("name")).sendKeys("RTX 4070 Ti");
        driver.findElement(By.name("tittle")).sendKeys("Tarjeta de video RTX 4070 Ti con envío a Perú");
        driver.findElement(By.name("weight")).sendKeys("2");
        driver.findElement(By.name("amount")).sendKeys("1");
        driver.findElement(By.name("price")).sendKeys("850");
        driver.findElement(By.name("status")).sendKeys("Disponible");
        driver.findElement(By.name("comision")).sendKeys("50");
        driver.findElement(By.name("registerOrder")).click();

        // WAIT TO THE ALERT IS AVAILABLE
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.alertIsPresent());
        // CHANGE THE FOCUS
        String confirmation= driver.switchTo().alert().getText();
        assertEquals(confirmation,"Order registered");
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
    }

    //ACCEPT ORDER FOR BUYERS
    @Test
    public void test4() {

        driver.get("http://localhost:4200/welcome");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.name("traveler")).click();
        driver.findElement(By.id("mat-input-0")).sendKeys("87654321");
        driver.findElement(By.id("mat-input-1")).sendKeys("nuevacontraseña");
        driver.findElement(By.cssSelector(".mat-button-wrapper")).click();
        // WAIT TO THE ALERT IS AVAILABLE
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        // CHANGE THE FOCUS
        Alert alert = driver.switchTo().alert();
        alert.accept();
        {
            WebElement element = driver.findElement(By.cssSelector(".mat-icon:nth-child(1)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".mat-icon:nth-child(1)")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".mat-list-item:nth-child(3) > .mat-list-item-content")).click();
        WebElement card = driver.findElement(By.id("order-card-0"));
        card.findElement(By.cssSelector(".mat-button-wrapper > span")).click();
        //driver.findElement(By.cssSelector(".cdk-focused > .mat-button-wrapper > span")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card-button")));
        driver.findElement(By.cssSelector(".card-button")).click();
        // WAIT TO THE ALERT IS AVAILABLE
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.alertIsPresent());
        // CHANGE THE FOCUS
        String confirmation= driver.switchTo().alert().getText();
        assertEquals(confirmation,"Order attached");


    }

    @AfterClass
    public void tearDown(){
        // Quit the driver
        //driver.quit();
    }

}
