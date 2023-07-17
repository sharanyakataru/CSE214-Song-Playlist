import static java.lang.System.out;


public class SongRecord {
    private String title;
    private String artist;
    private int length_minutes;
    private int length_seconds;

    /**
     *
     * @param title
     * title of the song
     * @param artist
     * artist of the song
     * @param length_minutes
     * minutes of the song
     * @param length_seconds
     * seconds of the song
     */
    public SongRecord(String title, String artist, int length_minutes, int length_seconds){
        this.title = title;
        this.artist = artist;
        this.length_minutes = length_minutes;
        this.length_seconds = length_seconds;
    }

    public SongRecord() {

    }

    /**
     *
     * @return the title of the song
     */
    public String getTitle(){
        return title;
    }

    /**
     *
     * @param title
     * sets the title of the song
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     *
     * @return the artist of the song
     */
    public String getArtist(){
        return artist;
    }

    /**
     *
     * @param artist
     * sets the artist of the song
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     *
     * @return the length of the song in minutes
     */
    public int getLength_minutes(){
        return length_minutes;
    }

    /**
     *
     * @param length_minutes
     * sets the length of the song in minutes
     * @throws IllegalArgumentException
     */
    public void setLength_minutes(int length_minutes){
        if(length_minutes < 0){
            throw new IllegalArgumentException("Minutes cannot be negative.");
        }
        this.length_minutes = length_minutes;
    }

    /**
     *
     * @return the length of the song in seconds
     */
    public int getLength_seconds() {
        return length_seconds;
    }

    /**
     *
     * @param length_seconds
     * sets the length of the song in seconds
     * @throws IllegalArgumentException
     */
    public void setLength_seconds(int length_seconds) {
        if(length_seconds < 0 || length_seconds > 59){
            throw new IllegalArgumentException("Seconds need to be in between 0 and 59.");
        }
        this.length_seconds = length_seconds;
    }

    /**
     *
     * @return prints the information about
     * the audio file in a single line
     */
    public String toString() {
        return title + " by " + artist + "[" + length_minutes + ":" + length_seconds + "]";
    }
}
