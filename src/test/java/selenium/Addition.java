package selenium;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Addition {

    @Test

    public void testAddTwoNumbers() throws InterruptedException {

        System.setProperty("web-driver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");

        Thread.sleep(2000);

        WebElement first = driver.findElement(By.tagName("input"));
        first.sendKeys("5");

        WebElement second = driver.findElement(By.name("n02"));
        second.sendKeys("8");

        WebElement button = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[7]/table/tbody/tr/td/table/tbody/tr/td/form/div[2]/div/div/input"));
        button.click();

        Thread.sleep(2000);

        //Hämta resultatet och jämför med förväntat resulat
        WebElement result = driver.findElement(By.name("answer"));
        String actual = result.getAttribute("value");
        String expected = "13";

        Thread.sleep(2000);

        //driver.quit();

        assertEquals(expected, actual);

    }

}