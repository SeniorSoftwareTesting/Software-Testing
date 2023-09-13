import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.io.IOException;
public class AutomatizareOpenCart extends Principal {
    public static void main(String[] args) throws FileNotFoundException {
        AutomatizareOpenCart obiect = new AutomatizareOpenCart();

        try (FileInputStream fis = new FileInputStream("JavaExcel.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0); // Obțineți prima foaie de lucru
            int rowCount = sheet.getLastRowNum();
            obiect.beforeTest();
            driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                String nume = row.getCell(0).getStringCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String email = row.getCell(2).getStringCellValue();
                String parola = row.getCell(3).getStringCellValue();
              //  int varsta = (int) row.getCell(4).getNumericCellValue();
                //identificam elementele pe pagina
                WebElement numeElement = driver.findElement(By.id("input-firstname"));
                WebElement prenumeElement = driver.findElement(By.id("input-lastname"));
                WebElement emailElement = driver.findElement(By.id("input-email"));
                WebElement parolaElement = driver.findElement(By.id("input-password"));
                WebElement subscribe = driver.findElement(By.id("input-newsletter-yes"));
                WebElement agree = driver.findElement(By.name("agree"));
                WebElement button_continue = driver.findElement(By.linkText("Continue"));
                //asteptam 5 secunde
                obiect.sleep(5);

                //facem scroll pana la butonul subscribe
                Actions actions = new Actions(driver);
                WebElement elementDeScroll = driver.findElement(By.id("input-newsletter-yes"));
                actions.moveToElement(elementDeScroll).perform();
                //completam cimpurile

                numeElement.sendKeys(nume);
                prenumeElement.sendKeys(prenume);
                emailElement.sendKeys(email);
                parolaElement.sendKeys(parola);
                subscribe.click();
                agree.click();
                button_continue.click();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        obiect.afterTest();
        }
    }

