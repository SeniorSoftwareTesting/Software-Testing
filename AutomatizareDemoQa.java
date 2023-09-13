import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AutomatizareDemoQa extends Principal {
    public static void main(String[] args) throws FileNotFoundException {
        AutomatizareDemoQa ob1 = new AutomatizareDemoQa();
        ob1.beforeTest();
        String url = "https://demoqa.com/webtables";
        try (FileInputStream fis = new FileInputStream("JavaExcel.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0); // Obțineți prima foaie de lucru
            int rowCount = sheet.getLastRowNum();
            driver.get(url);
            ob1.sleep(3);
            ArrayList<String> Nume = new ArrayList<>();
            ArrayList<String> Prenume = new ArrayList<>();
            ArrayList<String> Email = new ArrayList<>();
            ArrayList<String> Virsta = new ArrayList<>();
            ArrayList<String> Salariu = new ArrayList<>();
            ArrayList<String> Departament = new ArrayList<>();
            for (int i=1;i<=rowCount;i++) {
                Row row = sheet.getRow(i);
                Nume.add(row.getCell(0).getStringCellValue());
                Prenume.add(row.getCell(1).getStringCellValue());
                Email.add(row.getCell(2).getStringCellValue());
                Virsta.add(row.getCell(3).getStringCellValue());
                Salariu.add(row.getCell(4).getStringCellValue());
                Departament.add(row.getCell(5).getStringCellValue());
            }
            for (int j = 0;j<rowCount;j++) {
                WebElement buton_add = driver.findElement(By.id("addNewRecordButton"));
                buton_add.click();
                WebElement firstName = driver.findElement(By.id("firstName"));
                WebElement lastname = driver.findElement(By.id("lastName"));
                WebElement email = driver.findElement(By.id("userEmail"));
                WebElement age = driver.findElement(By.id("age"));
                WebElement salary = driver.findElement(By.id("salary"));
                WebElement departament = driver.findElement(By.id("department"));
                WebElement submit_buton = driver.findElement(By.id("submit"));
                firstName.sendKeys(Nume.get(j));
                lastname.sendKeys(Prenume.get(j));
                email.sendKeys(Email.get(j));
                age.sendKeys(Virsta.get(j));
                salary.sendKeys(Salariu.get(j));
                departament.sendKeys(Departament.get(j));
                submit_buton.click();

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}