package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.InvalidInputException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, String director, String artist, double cost) throws InvalidInputException {
        super(id, title, category, director, 0, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track already existed");
        } else {
            tracks.add(track);
            System.out.println("The track has been added");
        }
    }

    public void removeTrack(Track track) throws InvalidInputException {
        if (!tracks.contains(track)) {
            throw new InvalidInputException("ERROR: Track \"" + track.getTitle() + "\" does not exist in this CD");
        }
        tracks.remove(track);
        System.out.println("The track has been removed");
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("This CD can't be played");
            return;
        } else {
            System.out.println("Playing CD: " + getTitle());
            System.out.println("CD's Length: " + getLength());
            System.out.println("CD's Artist: " + getArtist());
        }
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + " - " + getLength() + ": " + getCost() + " $";
    }

    public ArrayList<Track> getTracks() {
        return this.tracks;
    }
}
