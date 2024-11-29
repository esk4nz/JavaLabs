/**
 * Represents a music composition with attributes like artist, title, genre, and duration.
 */
public class Composition {
    private final String artist;
    private final String title;
    private final String genre;
    private final int duration;

    /**
     * Constructs a Composition object.
     *
     * @param artist   The name of the artist.
     * @param title    The title of the composition.
     * @param genre    The genre of the composition.
     * @param duration The duration of the composition in seconds (must be positive).
     * @throws IllegalArgumentException if duration is non-positive.
     */
    public Composition(String artist, String title, String genre, int duration) {
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    /**
     * Returns the artist of the composition.
     *
     * @return The artist name.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the title of the composition.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the duration of the composition.
     *
     * @return The duration in seconds.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns the genre of the composition.
     *
     * @return The genre.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns a string representation of the composition, including its artist,
     * title, genre, and duration.
     *
     * @return A string containing the composition's details in the format:
     *         "artist: {artist}, title: {title}, genre: {genre}, duration: {duration}".
     */
    @Override
    public String toString() {
        return "artist: " + artist + ", title: " + title + ", genre: " + genre + ", duration: " + duration;
    }
}
