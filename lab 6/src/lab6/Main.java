package lab6;

import java.util.List;

/**
 * Main class to demonstrate the functionality of the Album and Composition classes.
 */
public class Main {
    /**
     * Entry point of the program. Demonstrates adding compositions to an album,
     * sorting them by genre, and finding compositions within a specific duration range.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // 1. Demonstrating the use of the empty constructor
        // Creating an empty album
        Album album1 = new Album("My Empty Album");

        // Printing the title and total duration of the album in seconds and minutes
        System.out.println("Album 1 title: " + album1.getTitle());
        System.out.println("Duration of Album 1:(" + album1.getTitle() + "): " + album1.getDurationOfAlbum() + " seconds");
        System.out.println("Duration of Album 1: (" + album1.getTitle() + "): " + album1.getDurationOfAlbum() / 60 + "." + album1.getDurationOfAlbum() % 60 + " minutes");

        // Displaying the contents of the album (expected to be empty)
        album1.outPut();

        // Adding a RockComposition to the album
        album1.addComposition(new RockComposition("Queen", "Bohemian Rhapsody", 354));

        // Displaying the contents of the album after adding a composition
        album1.outPut();

        // Sorting compositions in the album by genre
        System.out.println("Album 1 after sorting by genre:");
        album1.sorting();
        album1.outPut();
        System.out.println();

        // 2. Demonstrating the use of a constructor with a single composition
        // Creating a RockComposition object
        RockComposition rockTrack1 = new RockComposition("Queen", "Bohemian Rhapsody", 354);

        // Creating an album initialized with a single composition
        Album album2 = new Album("My Single Track Album", rockTrack1);

        // Printing the title and total duration of the album in seconds and minutes
        System.out.println("Album 2 title: " + album2.getTitle());
        System.out.println("Duration of Album 2:(" + album2.getTitle() + "): " + album2.getDurationOfAlbum() + " seconds");
        System.out.println("Duration of Album 2: (" + album2.getTitle() + "): " + album2.getDurationOfAlbum() / 60 + "." + album2.getDurationOfAlbum() % 60 + " minutes");

        // Displaying the contents of the album
        System.out.println("Album 2 compositions:");
        album2.outPut();

        // Sorting compositions in the album by genre
        System.out.println("Album 2 after sorting by genre:");
        album2.sorting();
        album2.outPut();
        System.out.println();

        // 3. Demonstrating the use of a constructor with a collection of compositions
        // Creating a list of compositions
        List<Composition> compositions = List.of(
                new RockComposition("Queen", "Bohemian Rhapsody", 354),
                new RockComposition("Nirvana", "Smells Like Teen Spirit", 301),
                new JazzComposition("Take Five", "Dave Brubeck", 324),
                new JazzComposition("So What", "Miles Davis", 545),
                new ClassicComposition("Symphony No. 9", "Ludwig van Beethoven", 1800),
                new ClassicComposition("Clair de Lune", "Claude Debussy", 320)
        );

        // Creating an album initialized with a collection of compositions
        Album album3 = new Album("My Collection Album", compositions);

        // Printing the title and total duration of the album in seconds and minutes
        System.out.println("Album 3 title: " + album3.getTitle());
        System.out.println("Duration of Album 3:(" + album3.getTitle() + "): " + album3.getDurationOfAlbum() + " seconds");
        System.out.println("Duration of Album 3: (" + album3.getTitle() + "): " + album3.getDurationOfAlbum() / 60 + "." + album3.getDurationOfAlbum() % 60 + " minutes");

        // Displaying the contents of the album
        System.out.println("Album 3 compositions:");
        album3.outPut();
        System.out.println();

        // Sorting compositions in the album by genre
        System.out.println("Album 3 after sorting by genre:");
        album3.sorting();
        album3.outPut();
        System.out.println();

        // Searching for compositions with a duration between 301 and 320 seconds
        System.out.println("Compositions in Album 3 with duration between 301 and 320 seconds:");
        album3.findByDuration(301, 320);
        album3.findByDuration(1, 5);
        album3.findByDuration(1, 2000);
    }
}
