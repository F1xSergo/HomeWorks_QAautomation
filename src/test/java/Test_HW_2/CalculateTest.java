package Test_HW_2;

import Sergei_Hotynyuk_HW_2.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateTest {
    private Calculator calc;

    @BeforeEach
    public void createCalculator() {
        calc = new Calculator(2, 2);
    }

    @Test
    public void testSub() {
        assertEquals(calc.calculate('-'), 0, 0);
    }

    @Test
    public void testSum() {
        assertEquals(calc.calculate('+'), 4, 0);
    }

    @Test
    public void testMult() {
        assertEquals(calc.calculate('*'), 4, 0);
    }

    @Test()
    public void testDiv() {
        assertEquals(calc.calculate('/'), 1, 0);
    }

    @Test
    public void testEx() {
        assertEquals(calc.calculate('^'), 4, 0);
    }

    @Test
    public void testSqrt() {
        Calculator calc = new Calculator(81);
        assertEquals(calc.calculate('№'), 9, 0);
    }

    @Test
    public void testShouldThrowArithmeticExceptionWhenDivisionZero() {// кода b = 0, то тест зеленый
        Calculator calc = new Calculator(2, 0);
        assertThrows(ArithmeticException.class,
                () -> calc.calculate('/'), "Expected division zero");
        System.out.println("division zero thrown");
    }

    @Test // проверил работу метода при  сложении
    public void testVarMethod() {
        int v = calc.varMethod(1, 2, 3, 4, 5, 6);
        assertEquals(v, 21, 0);
    }
}
