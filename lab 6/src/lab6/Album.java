package lab6;

import java.util.Collection;
import java.util.Comparator;

/**
 * Represents a music album containing a collection of compositions.
 */
public class Album {
    private final String title;
    private CompositionList album;

    /**
     * Constructs an album with a title and an empty list of compositions.
     *
     * @param title The title of the album.
     */
    public Album(String title) {
        this.title = title;
        this.album = new CompositionList();
    }

    /**
     * Constructs an album with a title and one composition.
     *
     * @param title       The title of the album.
     * @param composition A single composition to add to the album.
     */
    public Album(String title, Composition composition) {
        this.title = title;
        this.album = new CompositionList(composition);
    }

    /**
     * Constructs an album with a title and a collection of compositions.
     *
     * @param title        The title of the album.
     * @param compositions A collection of compositions to add to the album.
     */
    public Album(String title, Collection<Composition> compositions) {
        this.title = title;
        this.album = new CompositionList(compositions);
    }

    /**
     * Adds a composition to the album.
     *
     * @param composition The composition to add (must not be null).
     * @throws IllegalArgumentException if the composition is null.
     */
    public void addComposition(Composition composition) {
        if (composition == null) {
            throw new IllegalArgumentException("Composition cannot be null.");
        }
        album.add(composition);
    }

    /**
     * Returns the title of the album.
     *
     * @return The album title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Calculates the total duration of all compositions in the album.
     *
     * @return The total duration in seconds.
     */
    public int getDurationOfAlbum() {
        int sum = 0;
        for (Composition composition : album) {
            sum += composition.getDuration();
        }
        return sum;
    }

    /**
     * Sorts the compositions in the album by genre in case-insensitive order.
     *
     * @throws IllegalStateException if the album is empty.
     */
    public void sorting() {
        if (album.isEmpty()) {
            throw new IllegalStateException("Cannot sort an empty album.");
        }
        CompositionList sortedAlbum = new CompositionList();
        album.stream()
                .sorted(Comparator.comparing(Composition::getGenre, String::compareToIgnoreCase))
                .forEach(sortedAlbum::add);
        album = sortedAlbum;
    }

    /**
     * Outputs the compositions in the album to the console.
     * Prints a message if the album is empty.
     */
    public void outPut() {
        if (album.isEmpty()) {
            System.out.println("The album is empty. No compositions to display.");
            return;
        }
        for (Composition composition : album) {
            System.out.println(composition.toString());
        }
    }

    /**
     * Finds and outputs compositions in the album with durations in the given range.
     *
     * @param min The minimum duration (must be positive and less than max).
     * @param max The maximum duration (must be positive and greater than min).
     * @throws IllegalArgumentException if the durations are invalid.
     */
    public void findByDuration(int min, int max) {
        if (album.isEmpty()) {
            System.out.println("The album is empty. No compositions to search.");
            return;
        }
        if (min <= 0 || max <= 0) {
            throw new IllegalArgumentException("Duration values cannot be negative or be equal to 0.");
        }
        if (min >= max) {
            throw new IllegalArgumentException("Minimum duration cannot be equal to or greater than maximum duration.");
        }
        boolean found = false;
        System.out.println("\n\n\nThe found compositions: ");
        for (Composition composition : album) {
            if (composition.getDuration() >= min && composition.getDuration() <= max) {
                System.out.println(composition.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("There is no such composition.");
        }
    }
}
