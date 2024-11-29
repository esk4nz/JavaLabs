import java.util.ArrayList;
import java.util.List;

/**
 * Represents a text composed of multiple sentences.
 */
public class Text {
    private List<Sentence> sentences;

    /**
     * Constructs a Text from a string.
     *
     * @param text The string representation of the text.
     * @throws IllegalArgumentException If the text is empty or invalid.
     * @throws RuntimeException         If the text contains invalid punctuation.
     */
    public Text(String text) {
        if (text.equals("") || text.matches("[\\s]*")) {
            throw new IllegalArgumentException("Text cannot be empty");
        } else if (text.matches("[\\s!,.?;]*")) {
            throw new IllegalArgumentException("Text cannot consist only of punctuation marks");
        }
        sentences = new ArrayList<>();
        String[] sentenceArray = text.split("(?<=[.!?;])");
        for (String rawSentence : sentenceArray) {
            if (rawSentence.trim().matches("^,.*|.*,$")) {
                throw new RuntimeException("The sentence can't start or end with a comma.");
            }
            sentences.add(new Sentence(rawSentence));
        }
    }

    /**
     * Processes the text by swapping the first and last words in each sentence.
     */
    public void processText() {
        for (Sentence sentence : sentences) {
            sentence.swapFirstAndLastWords();
        }
    }

    /**
     * Constructs and returns the string representation of the text.
     * The string is composed of the concatenation of all sentences
     * in their respective order.
     *
     * @return A string representing the text, created by combining
     *         all sentences in the text.
     */
    @Override
    public String toString() {
        String result = "";
        for (Sentence sentence : sentences) {
            result += sentence.toString();
        }
        return result;
    }

}
