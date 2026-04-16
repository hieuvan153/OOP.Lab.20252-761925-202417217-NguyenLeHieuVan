package hust.soict.globalict.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        if (this.getLength() <= 0) {
            System.out.println("This Track can't be played");
            return;
        } else {
            System.out.println("Playing Track: " + this.getTitle());
            System.out.println("Track Length: " + this.getLength());
        }
    }
}
