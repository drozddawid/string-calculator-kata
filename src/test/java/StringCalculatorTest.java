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
    void add_UnknownAmountOfNumbers_SumOfAllNumbers(){
        assertEquals(10, StringCalculator.add("1,2, 3 , 4"));
        assertEquals(0, StringCalculator.add("1,-2, -3 , 4"));
    }
    @Test
    void add_IllegalNumberFormat_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("1, b"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("b, 1"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("b, b"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("b"));
    }
    @Test
    void add_NumbersSplittedByCommaAndNewlineCharacter_SumOfAllNumbers(){
        assertEquals(15, StringCalculator.add("1\n 2, 3 \n4 \n 5"));
        assertEquals(5, StringCalculator.add("1\n-2,-3\n4\n5"));
    }
}