/**
 * Main class that demonstrates the usage of the Album and Composition classes.
 */
public class Main {

    /**
     * Entry point of the program. Demonstrates adding compositions to an album,
     * sorting them by genre, and finding compositions within a specific duration range.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create an album
        Album album = new Album("My album");

        // Display the album contents (expected to be empty at this point)
        album.outPut();
        System.out.println();

        // Creating rock compositions
        RockComposition rockTrack1 = new RockComposition("Queen", "Bohemian Rhapsody", 354);
        RockComposition rockTrack2 = new RockComposition("Nirvana", "Smells Like Teen Spirit", 301);

        // Creating classical compositions
        ClassicComposition classicTrack1 = new ClassicComposition("Symphony No. 9", "Ludwig van Beethoven", 1800);
        ClassicComposition classicTrack2 = new ClassicComposition("Clair de Lune", "Claude Debussy", 320);

        // Creating jazz compositions
        JazzComposition jazzTrack1 = new JazzComposition("Take Five", "Dave Brubeck", 324);
        JazzComposition jazzTrack2 = new JazzComposition("So What", "Miles Davis", 545);

        // Adding compositions to the album
        album.addComposition(rockTrack1);
        album.addComposition(rockTrack2);
        album.addComposition(classicTrack1);
        album.addComposition(classicTrack2);
        album.addComposition(jazzTrack1);
        album.addComposition(jazzTrack2);

        // Calculate and display the total duration of the album in seconds and minutes
        int duration = album.getDurationOfAlbum();
        System.out.println("Duration of album (" + album.getTitle() + "): " + duration + " seconds");
        System.out.println("Duration of album (" + album.getTitle() + "): " + duration / 60 + "." + duration % 60 + " minutes");

        // Display the album after sorting compositions by genre
        System.out.println("\nAlbum after sorting by genre:");
        album.sorting();
        album.outPut();

        // Demonstrating finding compositions within specific duration ranges
        album.findByDuration(301, 320);
        album.findByDuration(1, 5);
        album.findByDuration(1, 2000);
    }
}
