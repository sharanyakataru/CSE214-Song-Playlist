
public class Playlist {
    SongRecord [] songs;
    public static final int MAX_SONG_RECORDS = 50;
    int songs_currently_in_playlist;


    public Playlist(){
    super();
    songs_currently_in_playlist = 0;
    songs = new SongRecord[MAX_SONG_RECORDS];
    }

    /**Generates a copy of the playlist
     *
     * @return copy of the playlist, changes do not affect the original
     */
    public Object clone(){
    Playlist copy = new Playlist();
    copy.songs_currently_in_playlist = this.songs_currently_in_playlist;
    copy.songs = new SongRecord[MAX_SONG_RECORDS];
    for(int i = 0; i < this.songs_currently_in_playlist; i++){
       SongRecord original = this.songs[i];
       SongRecord copied = new SongRecord();
       copied.setTitle(original.getTitle());
       copied.setArtist(original.getArtist());
       copied.setLength_minutes(original.getLength_minutes());
       copied.setLength_seconds(original.getLength_seconds());
       copy.songs[i] = copied;
    }
        return copy;
    }

    /**
     *
     * @param obj
     * an object with which the playlist is compared
     * @return
     * return value of true indicates that a playlist object
     * with the same Song Records in the same order as the Playlist, otherwise the return value is false
     */
    public boolean equals (Object obj){
        if (obj == null || !(obj instanceof Playlist)){
            return false;
        }

        Playlist other = new Playlist();
        if(this.songs_currently_in_playlist != other.songs_currently_in_playlist){
            return false;
        }

        for(int i = 0; i < songs_currently_in_playlist; i++){
            if(!this.songs[i].equals(other.songs[i])){
                return false;
            }
        }

        return true;
    }

    /** Number of SongRecords currently in the playlist
     *
     * @return number of SongRecords in the playlist
     */
    public int size(){
        return songs_currently_in_playlist;
    }

    /**Adds songs into the Playlist
     *
     * @param song
     * the new Song Record object to add to the playlist
     * @param position the position in the playlist where the song will be added
     * @throws FullPlaylistException
     */
    public void addSong(SongRecord song, int position){
        if(position < 1 || position > songs_currently_in_playlist + 1){
            throw new IllegalArgumentException("That position is not within the valid range.");
        }
        if (songs_currently_in_playlist > MAX_SONG_RECORDS){
            try {
                throw new FullPlaylistException("There is no more room inside of the playlist " +
                        "to store the new SongRecord object.");
            } catch (FullPlaylistException e) {
                throw new RuntimeException(e);
            }

        }
        for (int i = songs_currently_in_playlist; i >= position; i--){
            songs[i] = songs[i - 1];
        }
        songs[position - 1] = song;
        songs_currently_in_playlist++;
    }

    /**Removes song from the playlist
     *
     * @param position
     * the position in the playlist where the song will be removed from
     */
    public void removeSong (int position){
        if(1 > position || position > songs_currently_in_playlist){
            throw new IllegalArgumentException("That position is not within the valid range.");
        }
        for (int i = position - 1; i < songs_currently_in_playlist - 1; i++){
            songs[i] = songs[i + 1];
        }
        songs[songs_currently_in_playlist - 1] = null;
        songs_currently_in_playlist --;
    }

    /** Gets the song from the given position
     *
     * @param position
     * position of the song record to retrieve
     * @return
     * the Song Record at th given position in the playlist object
     */
    public SongRecord getSong(int position){
        if(1 > position || position > songs_currently_in_playlist){
            throw new IllegalArgumentException("That position is not within the valid range.");
        }
        return songs[position - 1];
    }

    /**Prints a table of each Song Record in the playlist on its own line with position number
     */
    public void printAllSongs(){
        if(songs_currently_in_playlist == 0){
            System.out.println("Playlist is empty.");
        }
        System.out.println("Song#         Title                  Artist          Length " +
                "\n------------------------------------------------");
        for(int i = 0; i < songs_currently_in_playlist; i ++){
            SongRecord song = songs[i];
            System.out.printf("%-6d %-17s %-17s %d: %02d\n", i + 1,
                    song.getTitle(), song.getArtist(), song.getLength_minutes(), song.getLength_seconds());
        }

    }

    /**Creates a new playlist with all the Song Records by the specified artist
     *
     * @param artist
     * the name of the artist
     * @param originalList
     * the original playlist
     * @return
     * a new playlist with song records from the particular artist
     */
    public static Playlist getSongsByArtist(String artist, Playlist originalList){
        if(originalList == null || artist == null){
            return null;
        }
        Playlist artist_list = new Playlist();
        for (int i = 0; i < originalList.songs_currently_in_playlist; i ++ ){
            SongRecord song = originalList.songs[i];
            if(song.getArtist().equals(artist)){
                artist_list.addSong(song, artist_list.songs_currently_in_playlist + 1);
            }
        }
        return artist_list;
    }

    /**String representation of the Playlist object
     *
     * @return
     * the string representation of the playlist object
     */
    public String toString() {
        if(songs_currently_in_playlist == 0){
            return "Playlist is empty";
        }
        String table = String.format("Song#    Title           Artist          Length " +
                "\n------------------------------------------------\n");
        for(int i = 0; i < songs_currently_in_playlist; i ++){
            SongRecord song = songs[i];
            table = table + String.format("%-6d %-17s %-17s %d: %02d\n",i + 1,
                    song.getTitle(), song.getArtist(), song.getLength_minutes(), song.getLength_seconds());
        }
        return table;
    }

}
