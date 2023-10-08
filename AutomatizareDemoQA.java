
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

        public class AutomatizareDemoQA extends Principal{
        public static void main(String[] args) {
            Principal ob = new Principal();
            ob.beforeTest();
            driver.get("https://demoqa.com/webtables");

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(new File("demoqa.xlsx"));
                Workbook wb = new XSSFWorkbook(fis);
                Sheet sheet = wb.getSheetAt(0);
                for (Row row : sheet) {
                    if (row.getRowNum() == 0) continue; // skip the header row

                    String nume = row.getCell(0).getStringCellValue();
                    String prenume = row.getCell(1).getStringCellValue();
                    int varsta = (int) row.getCell(2).getNumericCellValue();
                    String email = row.getCell(3).getStringCellValue();
                    int salariu = (int) row.getCell(4).getNumericCellValue();
                    String profesie = row.getCell(5).getStringCellValue();

                    WebElement btn_add = driver.findElement(By.id("addNewRecordButton"));
                    btn_add.click();

                    WebElement first_name_input = driver.findElement(By.id("firstName"));
                    WebElement last_name_input = driver.findElement(By.id("lastName"));
                    WebElement email_input = driver.findElement(By.id("userEmail"));
                    WebElement age_input = driver.findElement(By.id("age"));
                    WebElement salary_input = driver.findElement(By.id("salary"));
                    WebElement departament_input = driver.findElement(By.id("department"));
                    WebElement btn_submit = driver.findElement(By.id("submit"));

                    first_name_input.sendKeys(nume);
                    last_name_input.sendKeys(prenume);
                    email_input.sendKeys(email);
                    age_input.sendKeys(String.valueOf(varsta));
                    salary_input.sendKeys(String.valueOf(salariu));
                    departament_input.sendKeys(profesie);
                    btn_submit.click();
                }
            } catch (Exception e) {
                System.out.println("Virsta de " + e.getMessage() + " nu a putut fi introdusa");
            } finally {
                System.out.println("Exceptia a luat sfirsit");
                try {
                    if (fis != null) fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                driver.quit();
            }
        }
    }


