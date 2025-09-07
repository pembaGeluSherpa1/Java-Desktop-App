package MusicLibrary;

public class Main {
    public static void main(String[] args) {
        MusicLibrary musicLibrary = new MusicLibrary();

        musicLibrary.addSong("Photograph");
        musicLibrary.addSong("girls like you");
        musicLibrary.addSong("Memories");
        musicLibrary.removeSong("girls like you");
        musicLibrary.removeSong("love you");
        musicLibrary.play();
        musicLibrary.play();
        musicLibrary.play();
    }
}
