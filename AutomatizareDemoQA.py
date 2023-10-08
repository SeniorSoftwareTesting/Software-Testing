from selenium import webdriver
from selenium.webdriver.common.by import By
import openpyxl

#setam browserul firefox si dimensiunile la maxim
driver = webdriver.Firefox()
driver.maximize_window()
# accesam pagina
driver.get('https://demoqa.com/webtables')

# deschidem fisierul excel si foaia de lucru din care vom extrage date
wb = openpyxl.load_workbook("demoqa.xlsx")
sheet = wb.active

# asteptam 3 secunde inainte de a incepe testul
driver.implicitly_wait(3)
try:
    # iteram prin fiecare celula din excel si introducem valorile in variabilele de mai jos
    for row in sheet.iter_rows(min_row=2, values_only=True):
        nume, prenume, varsta, email, salariu, profesie = row
        # identificam campurile de care avem nevoie
        btn_add = driver.find_element(By.ID, 'addNewRecordButton')
        btn_add.click()
        first_name_input = driver.find_element(By.ID, "firstName")
        last_name_input = driver.find_element(By.ID, 'lastName')
        email_input = driver.find_element(By.ID, 'userEmail')
        age_input = driver.find_element(By.ID, 'age')
        salary_input = driver.find_element(By.ID, 'salary')
        departament_input = driver.find_element(By.ID, 'department')
        btn_submit = driver.find_element(By.ID, 'submit')

    # completam campurile cu valorile necesare
        first_name_input.send_keys(nume)
        last_name_input.send_keys(prenume)
        email_input.send_keys(email)
        age_input.send_keys(str(varsta))
        salary_input.send_keys(str(salariu))
        departament_input.send_keys(profesie)
        btn_submit.click()
except:
    print(f"Virsta de {age_input} nu a putut fi introdusa")
finally:
    print("Exceptia a luat sfirsit")

    # asteptam 2 secunde si apoi inchidem browserul
driver.implicitly_wait(2)
driver.quit()
