package MusicLibrary;

import java.util.ArrayList;
import java.util.Random;

// WAP to create a class MusicLibrary with a collection of songs and method to add and remove songs and to play a random song

public class MusicLibrary {

    ArrayList<String> musicArrayList = new ArrayList<>();
    Random randomSong = new Random(musicArrayList.size());

    public void addSong(String song){
        musicArrayList.add(song);
    }

    public void removeSong(String song){
        if (musicArrayList.remove(song)) {
            System.out.println(song + " removed!");
        } else {
            System.out.println("Song not found in the library!");
        }
    }

    public void play(){
        if(musicArrayList.size() == 0){
            System.out.println("Music library is empty!!");
        }else{
            int index = randomSong.nextInt(musicArrayList.size());
            String song = musicArrayList.get(index);
            System.out.println(song + " is playing.........");
        }
    }
}
