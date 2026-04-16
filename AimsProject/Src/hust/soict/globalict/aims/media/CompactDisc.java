package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, String director, String artist, int cost) {
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

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("The track does not exist");
        } else {
            tracks.remove(track);
            System.out.println("The track has been removed");
        }
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
}
