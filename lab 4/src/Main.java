/**
 * The entry point for the program that processes and validates text.
 */
public class Main {
    /**
     * Main method to execute the program logic.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
// The program accepts only valid sentences. Invalid sentences are those that contain several characters of
// punctuation marks in a row, or if there is a comma at the beginning/end of the sentence (after/before ‘.’, ‘!’, ‘?’ and ‘;’)
// also if the text (line) contains the character ‘\n’
// If such a sentence or an empty sentence (without words, that is, without a single letter or number) is passed for processing, an exception will be thrown
// digits/numbers are also considered words

        // Sample text to process
        String text = "The,sun, sets behind the mountains, painting the sky with beautiful,\"colors\".in.I love reading" +
                " books, especially mystery novels.I love reading books, especially mystery novels. Novels love reading books, especially mystery i.Novels love reading books, especially mystery i." +
                "The city is bustling with people, cars, and street vendors. She enjoys traveling to new places and learning about different cultures. " +
                "They decided to take a walk by the beach to enjoy the fresh air.";
//        String text = "   The,sun,       sets behind the mountains; painting the sky with beautiful, colors.in.I love reading    ";
//        String text = " .I love reading    ";
//        String text = "         ;     I\t  u       ";
//        String text = "         ;     \t         ";
//        String text = "   The               sun   43  .";
//        String text = "     .     I love  reading,   ,     books.books love  reading I  .  .....";
        validateText(text);
        System.out.println("Before:");
        System.out.println(text);

        // Normalize spaces and tabs
        text = normalizeSpaces(text);

        // Process the text
        Text textObject = new Text(text);
        textObject.processText();

        System.out.println("After:");
        System.out.println(textObject);
    }

    /**
     * Replaces tabs with spaces and collapses multiple spaces into a single space.
     *
     * @param input The text to normalize.
     * @return The normalized text.
     */
    private static String normalizeSpaces(String input) {
        String normalized = ""; // Initialize an empty string
        boolean lastWasSpace = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '\t') {
                c = ' '; // Replace tab with space
            }
            if (c == ' ') {
                if (!lastWasSpace) {
                    normalized += c; // Add the first space
                    lastWasSpace = true;
                }
            } else {
                normalized += c; // Add any other character
                lastWasSpace = false;
            }
        }

        return normalized;
    }

    /**
     * Validates the input text for structural correctness.
     *
     * @param text The text to validate.
     * @throws IllegalArgumentException If the text is null.
     * @throws RuntimeException         If the text contains invalid punctuation or newline characters.
     */
    private static void validateText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        } else if (text.matches(".*[!?;,\\.]+(\\s*[!?;,\\.]+)+.*")) {
            throw new RuntimeException("Invalid text: found sequence of punctuation marks without any word in between.");
        } else if (text.contains("\n")) {
            throw new RuntimeException("Invalid text: contains a newline character.");
        }
    }
}
