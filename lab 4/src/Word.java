import java.util.ArrayList;
import java.util.List;

/**
 * Represents a word, composed of individual letters.
 */
public class Word {
    private List<Letter> letters;

    /**
     * Constructs a Word from a string.
     *
     * @param word The string representation of the word.
     */
    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Constructs and returns the string representation of the word.
     * The string is composed of the characters stored in the list of letters.
     *
     * @return A string representing the word, created by concatenating all characters
     *         of the letters in the word.
     */
    @Override
    public String toString() {
        String result = "";
        for (Letter letter : letters) {
            result += letter.getCharacter();
        }
        return result;
    }

    /**
     * Sets the first letter of the word to uppercase.
     */
    public void setFirstLetterToUpperCase() {
        if (!letters.isEmpty()) {
            letters.get(0).toUpperCase();
        }
    }

    /**
     * Sets the first letter of the word to lowercase.
     */
    public void setFirstLetterToLowerCase() {
        if (!letters.isEmpty()) {
            letters.get(0).toLowerCase();
        }
    }
}
