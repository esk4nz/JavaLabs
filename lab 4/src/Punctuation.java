/**
 * Represents a punctuation mark.
 */
public class Punctuation {
    private char mark;

    /**
     * Constructs a Punctuation object with the specified mark.
     *
     * @param mark The punctuation mark.
     */
    public Punctuation(char mark) {
        this.mark = mark;
    }

    /**
     * Returns the punctuation mark.
     *
     * @return The punctuation mark.
     */
    public char getMark() {
        return mark;
    }

    /**
     * Returns the string representation of the punctuation mark.
     *
     * @return A string containing the punctuation mark represented by this object.
     */
    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}
