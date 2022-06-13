import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    // test naming convention: (method name)_(state under test)_(expected behavior)
    @Test
    void add_EmptyString_Zero() {
        assertEquals(0, StringCalculator.add(""));
    }
    @Test
    void add_SingleNumber_SingleNumber(){
        assertEquals(1, StringCalculator.add("1"));
        assertEquals(0, StringCalculator.add("0"));
        assertEquals(-1, StringCalculator.add("-1"));
    }
    @Test
    void add_TwoNumbers_SumOfTwoNumbers(){
        assertEquals(5, StringCalculator.add("2, 3"));
        assertEquals(-1, StringCalculator.add("2, -3"));
        assertEquals(1, StringCalculator.add("-2, 3"));
        assertEquals(-5, StringCalculator.add("-2, -3"));
    }
    @Test
    void add_IllegalNumberFormat_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("1, b"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("b, 1"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("b, b"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("b"));
    }
}