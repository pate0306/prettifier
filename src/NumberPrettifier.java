/**
 * A utility to prettify a floating point number.
 */
public interface NumberPrettifier {
    /**
     * Truncates extra decimal points and appends a suffix based on the value of the number.
     *
     * @param number Number to prettify
     * @return Prettified result
     */
    String prettify(float number);
}
