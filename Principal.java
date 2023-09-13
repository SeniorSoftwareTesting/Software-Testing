import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Principal {
    public static WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
         driver.manage().window().maximize();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    }

