import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sentence composed of words and punctuation marks.
 */
public class Sentence {
    private List<Object> components; // Can be Word or Punctuation

    /**
     * Constructs a Sentence from a string.
     *
     * @param sentence The string representation of the sentence.
     */
    public Sentence(String sentence) {
        components = new ArrayList<>();
        String tempWord = "";
        for (char c : sentence.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                tempWord += c;
            } else {
                if (!tempWord.isEmpty()) {
                    components.add(new Word(tempWord));
                    tempWord = "";
                }
                components.add(new Punctuation(c));
            }
        }
        if (!tempWord.isEmpty()) {
            components.add(new Word(tempWord));
        }
    }

    /**
     * Swaps the first and last words in the sentence.
     */
    public void swapFirstAndLastWords() {
        int firstWordIndex = -1, lastWordIndex = -1;

        for (int i = 0; i < components.size(); i++) {
            if (components.get(i) instanceof Word) {
                if (firstWordIndex == -1) {
                    firstWordIndex = i;
                }
                lastWordIndex = i;
            }
        }

        if (firstWordIndex != -1 && lastWordIndex != -1 && firstWordIndex != lastWordIndex) {
            Word firstWord = (Word) components.get(firstWordIndex);
            Word lastWord = (Word) components.get(lastWordIndex);

            firstWord.setFirstLetterToLowerCase();
            lastWord.setFirstLetterToUpperCase();

            components.set(firstWordIndex, lastWord);
            components.set(lastWordIndex, firstWord);
        }
    }

    /**
     * Constructs and returns the string representation of the sentence.
     * The string is composed of the concatenation of all its components
     * (words and punctuation marks) in their respective order.
     *
     * @return A string representing the sentence, created by combining
     *         all components of the sentence.
     */
    @Override
    public String toString() {
        String result = "";
        for (Object component : components) {
            result += component.toString();
        }
        return result;
    }

}
