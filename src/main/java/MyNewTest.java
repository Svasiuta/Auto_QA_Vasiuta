import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sergii_Vasiuta on 10.01.2017.
 */
public class MyNewTest {
//D:\JavaRushHomeWork
    @Test
    public void testSite()
    {
//        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("http://rozetka.com.ua/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.findElement(By.cssSelector("input.rz-header-search-input-text"))
                .sendKeys("Iphone"+ Keys.ENTER);
        String result = driver.findElement(By.cssSelector("a.filter-active-i-link")).getText();
        assert result.equals("Apple");
        System.out.println("Test done");
        driver.quit();
    }
}
