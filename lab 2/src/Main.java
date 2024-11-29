public class Main {
    public static void main(String[] args) {
//        Програма приймає лише валідні речення. Невалідними вважаються речення, де декілька йде декілька знаків
//        пунктуації підряд, або якщо на початку/вкінці речення (після/перед ".", "!", "?" та ";") стоїть кома
//        також, якщо текст (рядок) містить символ "\n"
//        Якщо таке речення або пусте речення (без слів, тобто без жодної літери або цифри) буде передано на обробку викличеться вийняток (Exception)
//        цифри/числа також вважаються за слова

//      Змінна в якій зберігається текст, з яким будемо працювати.
        String text = "The,sun, sets behind the mountains, painting the sky with beautiful,\"colors\".in.I love reading" +
                " books, especially mystery novels.I love reading books, especially mystery novels. " +
                "The city is bustling with people, cars, and street vendors. She enjoys traveling to new places and learning about different cultures. " +
                "They decided to take a walk by the beach to enjoy the fresh air.";
//        String text = "         ;     \t         ";
//        String text = "         ;     I  u       ";
//        String text = "     .     I love  reading,   ,     books.books love  reading I  .  .....";
//        String text = "   The,sun,       sets behind the mountains; painting the sky with beautiful, colors.in.I love reading    ";
//        String text = " .I love reading    ";
//        String text = "         ;     I  u       ";
//        String text = "   The               sun   43  .";
        validateText(text);
        System.out.println("Before:");
        System.out.println(text);
        // Об'єкт класу WordsSwapper - клас, у якому відбувається перестановка першого та останнього слів.
        WordsSwapper swapper = new WordsSwapper(text);
        System.out.println("After:");
        //Змінна результату, у який записується текст з перестановленими словами.
        String result = swapper.swap();
        System.out.println(result);
    }

    // Метод для перевірки речення на валідацію
    private static void validateText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
            // Регулярний вираз для виявлення послідовностей пунктуаційних знаків без слів між ними
        } else if (text.matches(".*[!?;,\\.]+(\\s*[!?;,\\.]+)+.*")) {
            throw new RuntimeException("Invalid text: found sequence of punctuation marks without any word in between.");
        } else if (text.contains("\n")) {
            throw new RuntimeException("Invalid text: contains a newline character.");
        }
    }



}