import java.text.DecimalFormat;

/**
 * Prettifies positive floating point numbers by truncating extra digits,
 * rounding decimal numbers to a single digit precision and appending a suffix determining the number value.
 */
public class NumberPrettifierImpl implements NumberPrettifier {

    private final DecimalFormat formatter;

    public NumberPrettifierImpl() {
        formatter = new DecimalFormat("#.#");
    }

    /**
     * Returns a simplified string of a positive float by appending a value suffix (supports millions,
     * billions, and trillions) and removes extra decimal digits by rounding to a single digit precision.
     * {@link IllegalArgumentException} is thrown if a negative number is passed.
     *
     * @param number Number to prettify
     * @return Prettified string
     */
    public String prettify(float number) {
        String suffix = "";

        if (number < 0) {
            throw new IllegalArgumentException("Negative number are not supported.");
        }

        if (number >= 1000000000000f) {
            number = number / 1000000000000f;
            suffix = "T";
        } else if (number >= 1000000000f) {
            number = number / 1000000000f;
            suffix = "B";
        } else if (number >= 1000000) {
            number = number / 1000000;
            suffix = "M";
        }
        return String.format("%s%s", formatter.format(number), suffix);
    }
}
