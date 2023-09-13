import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.github.javafaker.Faker;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreareFisierExcel {
    public static void main(String[] args) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Date Personale");
            Faker faker = new Faker();

            // Crearea rândului pentru antetul coloanelor
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Nume");
            headerRow.createCell(1).setCellValue("Prenume");
            headerRow.createCell(2).setCellValue("Email");
            headerRow.createCell(3).setCellValue("Varsta");
            headerRow.createCell(4).setCellValue("Salariu");
            headerRow.createCell(5).setCellValue("Departament");

            // Adăugarea datelor fictive pentru 50 de rânduri folosind Java Faker
            for (int i = 1; i <= 50; i++) {
                Row row = sheet.createRow(i);
                row.createCell(0).setCellValue(faker.name().firstName());
                row.createCell(1).setCellValue(faker.name().lastName());
                row.createCell(2).setCellValue(faker.internet().emailAddress());
                row.createCell(3).setCellValue(faker.number().numberBetween(18, 65)); // Varsta intre 18 si 65 de ani
                row.createCell(4).setCellValue(faker.number().numberBetween(10000,30000));
                row.createCell(5).setCellValue(faker.address().cityName());
            }

            // Auto-size coloanele pentru a se potrivi cu conținutul
            for (int i = 0; i < 6; i++) {
                sheet.autoSizeColumn(i);
            }

            // Salvarea fișierului Excel
            try (FileOutputStream fileOut = new FileOutputStream("JavaExcel.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Fișierul Excel a fost creat cu succes!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

