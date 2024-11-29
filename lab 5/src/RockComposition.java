/**
 * Represents a rock music composition.
 */
public class RockComposition extends Composition {

    /**
     * Constructs a RockComposition object with a default genre of "Rock".
     *
     * @param artist   The artist of the composition.
     * @param title    The title of the composition.
     * @param duration The duration of the composition in seconds.
     */
    public RockComposition(String artist, String title, int duration) {
        super(artist, title, "Rock", duration);
    }
}
