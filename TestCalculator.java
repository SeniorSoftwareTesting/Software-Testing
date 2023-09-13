import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculator {
    Calculator calculator = new Calculator();
    @Test
    public void Test_adunare_calculator(){

        int result =  calculator.adunare(10,5);
        assertEquals(15,result);

    }
    @Test
    public void Test_scadere_calculator(){
        int result = calculator.scaderea(9,6);
        assertEquals(3,result);
    }
    @Test
    public void Test_inmultire_calculator(){
        int rezultat = calculator.inmultire(5,9);
        assertEquals(45,rezultat);

    }
    @Test
    public void Test_impartire_calculator(){
        int rezultat = calculator.impartire(15,3);
        assertEquals(5,rezultat);
    }
}
