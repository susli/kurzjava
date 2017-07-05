package com.mycompany.audiolibrary;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.stage.FileChooser;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class SongDaoImplFromFiles implements SongDao {

    private List<Song> songs;

    //      System.out.println("open file");
    FileChooser fc = new FileChooser();
    //  fc.setTitle("Choose audio file");

    private File srcDirectory = new File(
            "src" + File.separator + "main" + File.separator + "resources" + File.separator + "files");

    //private File srcDirectory = new File(System.getProperty("user.dir")); // aktuální složka programu
    //List<File> files = fc.showOpenMultipleDialog(null);
    public SongDaoImplFromFiles() {

        // File srcDirectory = new File(System.getProperty("user.dir")); // aktuální složka programu
        fc.setInitialDirectory(srcDirectory);

        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("mp3", "*.mp3"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("wav", "*.wav"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("ALL Files", "*.*"));

        //List<File> filess = fc.showOpenMultipleDialog(null);
        songs = new ArrayList<>();
        List<File> files = fc.showOpenMultipleDialog(null);
        if (files == null) {
            return;
        }
        for (File file : files) {
            AudioFile f;
            AudioHeader ah;
            Tag tag;
            try {
                f = AudioFileIO.read(file);
                tag = f.getTag();
                ah = f.getAudioHeader();

                int songLengthint = Integer.valueOf(ah.getTrackLength());
                int hours = (int) songLengthint / 3600;
                int remainder = (int) songLengthint - hours * 3600;
                int mins = remainder / 60;
                remainder = remainder - mins * 60;
                int secs = remainder;
                String songLength = "";
                if (hours != 0) {
                    songLength += String.valueOf(hours) + ":";
                }
                if (mins != 0) {
                    songLength += String.valueOf(mins) + ":";
                }
                songLength += String.valueOf(secs);

                songs.add(new Song(file.getName(), tag.getFirst(FieldKey.ARTIST), tag.getFirst(FieldKey.ALBUM),
                        Integer.valueOf(
                                (tag.getFirst(FieldKey.TRACK) != null && !tag.getFirst(FieldKey.TRACK).equals(""))
                                ? tag.getFirst(FieldKey.TRACK)
                                : "0"),
                        Integer.valueOf((tag.getFirst(FieldKey.YEAR) != null && !tag.getFirst(FieldKey.YEAR).equals(""))
                                ? tag.getFirst(FieldKey.YEAR)
                                : "0"),
                        tag.getFirst(FieldKey.GENRE), songLength));

            } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public List<Song> findByAlbum(String album) {
        List<Song> pomSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().equals(album)) {
                pomSongs.add(song);
            }
        }
        return pomSongs;
    }

    @Override
    public List<Song> findByInterpret(String interpret) {
        List<Song> pomSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getInterpret().equals(interpret)) {
                pomSongs.add(song);
            }
        }
        return pomSongs;
    }

    @Override
    public List<Song> findByGenre(String genre) {
        List<Song> pomSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getGenre().equals(genre)) {
                pomSongs.add(song);
            }
        }
        return pomSongs;
    }

    @Override
    public List<Song> findByYear(int year) {
        List<Song> pomSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getYear() == year) {
                pomSongs.add(song);
            }
        }
        return pomSongs;
    }

    @Override
    public List<Song> findByName(String name) {
        if (name != null) {
            if (name.equals("")) {
                return songs;
            }
        }
        List<Song> pomSongs = new ArrayList<>();
        for (Song song : songs) {
            if (SongDaoImpl.containsIgnoreCase(song.getName(), name)) {
                pomSongs.add(song);
            }
        }
        return pomSongs;
    }

    @Override
    public List<String> getInterprets() {
        List<String> pomStrings = new ArrayList<>();
        for (Song songs : songs) {
            if (!(pomStrings.contains(songs.getInterpret()))) {
                pomStrings.add(songs.getInterpret());
            }
        }
        return pomStrings;
    }

    @Override
    public List<String> getYears() {
        List<Integer> pomStrings = new ArrayList<>();
        // add
        for (Song songs : songs) {
            if (!(pomStrings.contains(songs.getYear()))) {
                pomStrings.add(songs.getYear());
            }
        }
        // sort
        Collections.sort(pomStrings);
        // copy
        List<String> newPomStrings = new ArrayList<String>(pomStrings.size());
        for (Integer myInt : pomStrings) {
            newPomStrings.add(String.valueOf(myInt));
        }
        // return
        return newPomStrings;
    }

    @Override
    public List<String> getAlbums() {
        List<String> pomStrings = new ArrayList<>();
        for (Song songs : songs) {
            if (!(pomStrings.contains(songs.getAlbum()))) {
                pomStrings.add(songs.getAlbum());
            }
        }
        return pomStrings;
    }

    @Override
    public List<String> getGenres() {
        List<String> pomStrings = new ArrayList<>();
        for (Song songs : songs) {
            if (!(pomStrings.contains(songs.getGenre()))) {
                pomStrings.add(songs.getGenre());
            }
        }
        return pomStrings;
    }

    /**
     * @return source directory
     */
    public File getSrcDirectory() {
        return srcDirectory;
    }

    /**
     * @param srcDirectory Source directory
     */
    public void setSrcDirectory(File srcDirectory) {
        this.srcDirectory = srcDirectory;
    }
}
