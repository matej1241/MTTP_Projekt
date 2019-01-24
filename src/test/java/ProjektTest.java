import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Array;

public class ProjektTest {

        //-----------------------------------Global Variables-----------------------------------
        //Declare a Webdriver variable
        public WebDriver driver;
        //Declare a test URL variable
        public String testURL = "http://stup.ferit.hr/";

        //-----------------------------------Test Setup-----------------------------------
        @BeforeMethod
        public void setupTest() {
            System.setProperty("webdriver.chrome.driver", "C:/Matej/MTTPP/chromedriver.exe");
            //Create a new ChromeDriver
            driver = new ChromeDriver();
            //Go to www.swtestacademy.com
            driver.navigate().to(testURL);
        }

        @Test
        public void stupTestPrakse() throws InterruptedException {
            WebElement testLink = driver.findElement(By.linkText("STRUČNE PRAKSE"));
            testLink.click();
            Thread.sleep(1000);
            testLink = driver.findElement(By.linkText("DIPLOMSKI STUDIJ"));
            testLink.click();
            Thread.sleep(1000);
            testLink = driver.findElement(By.linkText("STRUČNI STUDIJ"));
            testLink.click();
            Thread.sleep(1000);

        }

        @Test
        public void stupTestRadovi() throws InterruptedException {
            WebElement testLink = driver.findElement(By.linkText("ZAVRŠNI/DIPLOMSKI RADOVI"));
            testLink.click();
            Thread.sleep(1000);
            testLink = driver.findElement(By.name("s"));
            testLink.sendKeys("test");
            testLink.submit();
            Thread.sleep(1000);
        }

        @Test
        public void stupTest3xW() throws InterruptedException {
            WebElement testLink = driver.findElement(By.linkText("3xW R&D"));
            testLink.click();
            Thread.sleep(1000);
            testLink = driver.findElement(By.linkText("INTELIGENTNA VOZILA"));
            testLink.click();
            Thread.sleep(1000);
        }

        @Test
        public void stupTestDokumenti() throws InterruptedException {
            Actions builder = new Actions(driver);
            WebElement testLink;
            String[] dropDown = {"PRAVILNIK", "UPUTE O STRUČNOJ PRAKSI", "UPUTE – DNEVNIK RADA"};

            for(int i = 0; i<3 ; i++){
                Thread.sleep(1000);
                testLink = driver.findElement(By.linkText("DOKUMENTI"));
                builder.moveToElement(testLink).build().perform();
                Thread.sleep(1000);

                testLink = driver.findElement(By.linkText(dropDown[i]));
                testLink.click();
                Thread.sleep(1000);

                driver.navigate().to(testURL);
            }
        }

        @Test
        public void stupTestPrijavaTvrtke() throws InterruptedException {
            String username = "test";
            String password = "pass";

            WebElement testLink = driver.findElement(By.linkText("Prijavi se kao Tvrtka"));
            testLink.click();
            Thread.sleep(1000);

            testLink = driver.findElement(By.id("user_login"));
            testLink.sendKeys(username);

            testLink = driver.findElement(By.id("user_pass"));
            testLink.sendKeys(password);

            testLink = driver.findElement(By.name("submit"));
            testLink.click();
            Thread.sleep(1000);
        }

        //-----------------------------------Test TearDown-----------------------------------
        @AfterMethod
        public void teardownTest() {
            //Close browser and end the session
            driver.quit();
        }
}
