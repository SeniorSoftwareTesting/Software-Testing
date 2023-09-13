import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demoqa extends Principal{
    public static void main(String[] args) {
        String url_demoqa = "https://demoqa.com/webtables";
        Principal obiect = new Principal();
        obiect.beforeTest();
        driver.get(url_demoqa);
        obiect.sleep(5);
        WebElement buton_add = driver.findElement(By.id("addNewRecordButton"));
        buton_add.click();
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastname = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement age = driver.findElement(By.id("age"));
        WebElement salary = driver.findElement(By.id("salary"));
        WebElement departament = driver.findElement(By.id("department"));
        WebElement submit_buton = driver.findElement(By.id("submit"));

        firstName.sendKeys("Ion");
        lastname.sendKeys("Curmei");
        email.sendKeys("asfkk@gmail.com");
        age.sendKeys("30");
        salary.sendKeys("25000");
        departament.sendKeys("Software Testing");
        submit_buton.click();

        obiect.sleep(2);
        obiect.afterTest();
    }
}
