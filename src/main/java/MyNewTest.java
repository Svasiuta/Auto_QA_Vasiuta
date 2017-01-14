import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sergii_Vasiuta on 10.01.2017.
 */
public class MyNewTest {
//D:\JavaRushHomeWork

    public static final String INPUT_SELECTOR = "//input[contains";
    private WebDriver driver;

    @BeforeMethod
    public void initDriver (){
        //        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //navigate to reozetka
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get("http://rozetka.com.ua/");
    }

    @Test
    public void testSite()
    {


        //search for iphone
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.findElement(By.cssSelector("input.rz-header-search-input-text"))
                .sendKeys("Iphone"+ Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds 15);
        String result = driver.findElement(By.cssSelector("a.filter-active-i-link")).getText();
        if (true)throw  new RuntimeException();
        //Verify filter is enabled
        assert result.equals("Apple");
        System.out.println("Test done");
        Reporter.getCurrentTestResult().getStartMillis();

    }
    @AfterMethod
    public void destroyDriver(){
        if (driver!=null){
        driver.quit();
        }
        Reporter.getCurrentTestResult().getEndMillis();
        Reporter.log("Elapsed time: "+(Reporter.getCurrentTestResult().getEndMillis() -Reporter.getCurrentTestResult().getStartMillis()) );
    }
}
