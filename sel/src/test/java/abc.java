

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class abc {
        public static void main(String[] args) {

            // Setup ChromeDriver automatically using WebDriverManager
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            try {
                // 1. Navigate to Google
                driver.get(" https://web.qa.petgevity.co.uk/about-your-pet");



                // Enter the pet name
                WebElement petName = driver.findElement(By.id("petName"));

                petName.sendKeys("saman");
                Thread.sleep(2000);

                WebElement catLabel = driver.findElement(By.cssSelector("label[for='cat']"));

                catLabel.click();

                WebElement catType = driver.findElement(By.cssSelector("label[for='moggy']"));

                catType.click();

                WebElement catType2 = driver.findElement(By.cssSelector("label[for='male']"));

                catType2.click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement birthDate = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#day")));


                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", birthDate);
                Thread.sleep(500); // optional, gives a little buffer

                birthDate.click();  // in case it's not focused
                birthDate.sendKeys("22");

                WebElement birthMonth = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#month")));
                birthMonth.click();  // in case it's not focused
                birthMonth.sendKeys("05");

                WebElement birthYear = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#year")));
                birthYear.click();  // in case it's not focused
                birthYear.sendKeys("2023");


                WebElement microChip = driver.findElement(By.cssSelector("label[for='isMicroChipped-yes']"));

                microChip.click();


                WebElement neutered = driver.findElement(By.cssSelector("label[for='yesSN']"));

                neutered.click();

                WebElement petCost = driver.findElement(By.id("petCost"));

                petCost.sendKeys("25");

                Thread.sleep(5000);

                WebElement checkbox = driver.findElement(By.xpath("//label[@for='agreeAssumption']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
                Thread.sleep(5000); // Give it a sec to settle
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

       ;       System.out.println("This is done");

                WebElement postCode = driver.findElement(By.id("postCode"));

                postCode.sendKeys("NN47YB");

                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", postCode);
                Thread.sleep(500);


                WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));

                password.sendKeys("January*27");

                WebElement loginButton = driver.findElement(By.xpath("//input[@id='loginbutton']"));
                loginButton.click();



                // 4. Submit the search
                //emailaddress.submit();

                // 5. Wait a bit (not ideal, but ok for demo)
                Thread.sleep(12000);  // Use WebDriverWait in real tests

                // 6. Print the page title
                System.out.println("Page title is: " + driver.getTitle());

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                // 7. Close the browser
                driver.quit();
            }
        }
    }




