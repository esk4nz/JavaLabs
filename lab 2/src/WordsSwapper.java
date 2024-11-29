import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsSwapper {
    private String text;

    public WordsSwapper(String text) {
        if (text.equals("") || text.matches("[\\s]*")) {
            throw new IllegalArgumentException("Text cannot be empty");
        } else if (text.matches("[\\s!,.?;]*")) {
            throw new IllegalArgumentException("Text cannot consist only of punctuation marks");
        }

        this.text = text;
    }

    public String swap() {
        String[] sentences = text.split("[\\.!;?]+");
        String result = "";
        boolean f = false;
        int ammount = 0;
        for (String sentence : sentences) {
            if (sentence.matches(".*[a-zA-Z]+.*")) {
                ammount++;
            }
        }
        for (String sentence : sentences) {
            sentence = sentence.trim();

            if (sentence.matches("^,.*|.*,$")) {
                throw new RuntimeException("The sentence can't start or end with a comma.");
            }
            if (sentence.matches(".*[a-zA-Z]+.*")) {
                ammount--;
                if (ammount == 0) {
                    f = true;
                }
                String originalSentenceCopy = sentence;
                String[] words = sentence.split("[\\s,\"\']+");
                String firstWord = "";
                String lastWord = "";
                for (int i =0; i < words.length; i++) {
                    if (words[i].matches("[a-zA-Z]+")) {
                        firstWord = words[i];
                        break;
                    }
                }
                for (int i = words.length-1; i >= 0; i--) {
                    if (words[i].matches(".*[a-zA-Z].*") || words[i].matches(".*\\d.*")) {
                        lastWord = words[i];
                        break;
                    }
                }
                firstWord = Character.toLowerCase(firstWord.charAt(0)) + firstWord.substring(1);
                lastWord = Character.toUpperCase(lastWord.charAt(0)) + lastWord.substring(1);
                Pattern p0 = Pattern.compile(firstWord, Pattern.CASE_INSENSITIVE);
                Matcher m0 = p0.matcher(sentence);
                sentence = m0.replaceFirst(lastWord);
                Pattern p1 = Pattern.compile(lastWord, Pattern.CASE_INSENSITIVE);
                Matcher m1 = p1.matcher(sentence);
                int lastWordStart = 0;
                int lastWordEnd = 0;
                while (m1.find()) {
                    lastWordStart = m1.start();
                    lastWordEnd = m1.end();
                }
                String leftPart = sentence.substring(lastWordEnd);
                sentence = sentence.substring(0, lastWordStart);
                sentence = sentence + firstWord + leftPart;
                text = text.replaceFirst(originalSentenceCopy, sentence);
                Pattern p2 = Pattern.compile(sentence, Pattern.CASE_INSENSITIVE);
                Matcher m2 = p2.matcher(text);
                m2.find();
                if (f) {
                    result = result + text;
                    return result;
                }
                else {
                    result = result + text.substring(0, m2.end());
                }
                text = text.substring(m2.end());
            }
        }
        return result;
    }
}
