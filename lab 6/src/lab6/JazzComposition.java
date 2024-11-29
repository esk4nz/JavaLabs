package lab6;

/**
 * Represents a jazz music composition.
 */
class JazzComposition extends Composition {

    /**
     * Constructs a JazzComposition object with a default genre of "Jazz".
     *
     * @param title    The title of the composition.
     * @param artist   The artist of the composition.
     * @param duration The duration of the composition in seconds.
     */
    public JazzComposition(String title, String artist, int duration) {
        super(title, artist, "Jazz", duration);
    }
}
