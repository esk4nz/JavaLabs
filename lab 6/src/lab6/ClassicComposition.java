package lab6;

/**
 * Represents a classical music composition.
 */
class ClassicComposition extends Composition {

    /**
     * Constructs a ClassicComposition object with a default genre of "Classic".
     *
     * @param title    The title of the composition.
     * @param artist   The artist of the composition.
     * @param duration The duration of the composition in seconds.
     */
    public ClassicComposition(String title, String artist, int duration) {
        super(title, artist, "Classic", duration);
    }
}
