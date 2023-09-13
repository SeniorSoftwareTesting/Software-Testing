import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import static org.junit.Assert.assertEquals;
public class DragandDrop extends Principal {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        String url = "https://demoqa.com/droppable";
        driver.get(url);
        WebElement element = driver.findElement(By.id("draggable"));
        WebElement tinta = driver.findElement(By.id("droppable"));
        //mutam elementul "element" in tinta
        Actions action = new Actions(driver);
        action.dragAndDrop(element, tinta).build().perform();
        driver.quit();
    }
}