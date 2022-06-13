import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {
    // test naming convention: (method name)_(state under test)_(expected behavior)
    @Test
    void add_EmptyString_Zero() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void add_SingleNumber_SingleNumber() {
        assertEquals(1, StringCalculator.add("1"));
        assertEquals(0, StringCalculator.add("0"));
    }

    @Test
    void add_UnknownAmountOfNumbers_SumOfAllNumbers() {
        assertEquals(10, StringCalculator.add("1,2, 3 , 4"));
    }

    @Test
    void add_IllegalNumberFormat_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("1, b"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("b, 1"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("b, b"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("b"));
    }

    @Test
    void add_NumbersSplittedByCommaAndNewlineCharacter_SumOfAllNumbers() {
        assertEquals(15, StringCalculator.add("1\n 2, 3 \n4 \n 5"));
    }

    @Test
    void add_EmptyStringAfterCustomDelimiter_Zero() {
        assertEquals(0, StringCalculator.add("//;\n"));
    }

    @Test
    void add_SingleNumberAfterCustomDelimiter_SingleNumber() {
        assertEquals(1, StringCalculator.add("//;\n1"));
    }

    @Test
    void add_NumbersSplittedByCustomDelimiter_SumOfAllNumbers() {
        assertEquals(15, StringCalculator.add("//;\n1 ;2 , 3\n 4 ;5"));
        assertEquals(15, StringCalculator.add("// ; \n1 ;2 , 3\n 4 ;5"));
        assertEquals(15, StringCalculator.add("// : \n1 :2 , 3\n 4 :5"));
    }

    @Test
    void add_CustomDelimiterLongerThanOneCharacter_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("//ab\n1, 2, 3 ab 4"));
    }

    @Test
    void add_EmptyStringAsCustomDelimiter_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("//\n1, 2, 3, 4"));

    }

    @Test
    void add_NoNewlineCharacterAfterCustomDelimiterDeclaration_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("//1, 2, 3, 4"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("//1, 2 \n 3, 4"));
    }

    @Test
    void add_NegativeNumbers_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("1, 2, -3\n -4, -5"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("//;\n 1; -2; -4; 2"));
    }

    @Test
    void add_NumbersWithNumbersBiggerThan1000_SumOfNumbersLessOrEqual1000() {
        assertEquals(1010, StringCalculator.add("1,2,2, 1000, 1001, 1002, 4, 1, 2000, 3000"));
    }
}