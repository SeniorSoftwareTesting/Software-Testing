import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class Test02 extends Principal{
    @Test
    public void Test_verificare_titlu(){
        String url_python = "https://www.python.org/";
        driver.get(url_python);
        String titlu = driver.getTitle();
        assertEquals(titlu,"Welcome to Python.org");
    }


}
