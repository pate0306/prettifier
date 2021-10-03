import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberPrettifierTest {

    private NumberPrettifier numberPrettifier;
    private static final float OneMillion = 1000000;
    private static final float OneBillion = 1000000000;
    private static final float OneTrillion = 1000000000000f;

    @BeforeEach
    public void setUp() throws Exception {
        numberPrettifier = new NumberPrettifierImpl();
    }

    @AfterEach
    public void tearDown() throws Exception {
        numberPrettifier = null;
    }

    // String prettify(float number)

    @Test
    public void givenNegativeNumberInput_whenPrettify_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () ->
                numberPrettifier.prettify(-1)
        );
    }

    @Test
    public void givenNumberIsOneTrillion_whenPrettify_thenAppendSuffixT() {
        String expected = "1T";
        String actual = numberPrettifier.prettify(OneTrillion);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void givenNumberIsOneBillion_whenPrettify_thenAppendSuffixB() {
        String expected = "1B";
        String actual = numberPrettifier.prettify(OneBillion);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void givenNumberIsOneMillion_whenPrettify_thenAppendSuffixM() {
        String expected = "1M";
        String actual = numberPrettifier.prettify(OneMillion);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void givenNumberIsLessThanOneMillion_whenPrettify_thenDoNotAppendSuffix() {
        String expected = "123";
        String actual = numberPrettifier.prettify(123);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void givenNumberIsADecimalNumber_whenPrettify_thenRoundWithSingleDigitPrecision() {
        String expected = "2.5M";
        String actual = numberPrettifier.prettify(2500000.34f);

        Assertions.assertEquals(actual, expected);

        expected = "100.6";
        actual = numberPrettifier.prettify(100.56f);

        Assertions.assertEquals(actual, expected);

        expected = "1.1B";
        actual = numberPrettifier.prettify(1123456789);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void givenNumberInputIsZero_whenPrettify_thenReturnZero() {
        String expected = "0";
        String actual = numberPrettifier.prettify(0);

        Assertions.assertEquals(actual, expected);
    }
}