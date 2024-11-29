/**
 * Represents a single letter and provides methods for case conversion.
 */
public class Letter {
    private char character;

    /**
     * Constructs a Letter with the specified character.
     *
     * @param character The character for this letter.
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Returns the character of the letter.
     *
     * @return The character.
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Converts the letter to uppercase if it is lowercase.
     */
    public void toUpperCase() {
        if (character >= 'a' && character <= 'z') {
            character = (char) (character - 'a' + 'A');
        }
    }

    /**
     * Converts the letter to lowercase if it is uppercase.
     */
    public void toLowerCase() {
        if (character >= 'A' && character <= 'Z') {
            character = (char) (character - 'A' + 'a');
        }
    }

    /**
     * Returns the string representation of the letter.
     *
     * @return A string containing the character represented by this Letter object.
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }

}
