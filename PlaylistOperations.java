

import java.util.Scanner;
public class PlaylistOperations {
    private static Playlist playlist = new Playlist();
    //private static SongRecord song = new SongRecord();
    public static void main (String args[]){
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        while (flag){
            String userOptions = "A) Add Song\n" +
                    "B) Print Songs by Artist\n" +
                    "G) Get Song\n" +
                    "R) Remove Song\n" +
                    "P) Print All Songs\n" +
                    "S) Size\n" +
                    "Q) Quit";
            System.out.println(userOptions + "\nSelect a menu option: ");
            String letter = input.nextLine();
            letter = letter.toUpperCase();

            switch(letter){
                case "A":
                    try{
                        SongRecord song = new SongRecord();
                        System.out.println("Enter the song title: ");
                        String title = input.nextLine();
                        System.out.println("Enter the song artist: ");
                        String artist = input.nextLine();
                        System.out.println("Enter the song length (minutes): ");
                        int length_minutes = input.nextInt();
                        System.out.println("Enter the song length (seconds): ");
                        int length_seconds = input.nextInt();
                        System.out.println("Enter the position: ");
                        int position = input.nextInt();
                        input.nextLine();

                        song.setTitle(title);
                        song.setArtist(artist);
                        song.setLength_minutes(length_minutes);
                        song.setLength_seconds(length_seconds);

                        playlist.addSong(song,position);
                        System.out.println("Song Added: " + song.toString());

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "B":
                    try{
                        System.out.println("Enter the artist: ");
                        String artist = input.nextLine();
                        Playlist artist_playlist = playlist.getSongsByArtist(artist, playlist);
                        if (artist_playlist != null){
                            System.out.println("Songs performed by " + artist + ":");
                            System.out.println(artist_playlist);
                        }
                        else{
                            System.out.println("No songs found for the artist " + artist + ".");
                        }

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "G":
                    try{
                        System.out.println("Enter the position: ");
                        int position = input.nextInt();
                        SongRecord song = playlist.getSong(position);
                        System.out.println(song.toString());

                        input.nextLine();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "R":
                    try{
                        System.out.println("Enter the position: ");
                        int position = input.nextInt();
                        playlist.removeSong(position);
                        System.out.println("Song removed at position " + position);
                        input.nextLine();

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "P":
                    try{
                        playlist.printAllSongs();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "S":
                    try{
                        System.out.println("There are " + playlist.size() + " song(s) in the current playlist.");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "Q":
                    try{
                        System.out.println("Program terminating normally...");
                        System.exit(0);
                        flag = false;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }

    }

}