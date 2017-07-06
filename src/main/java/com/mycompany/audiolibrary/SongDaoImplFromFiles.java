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
    private File srcDirectory = new File(
            "src" + File.separator + "main" + File.separator + "resources" + File.separator + "files");
    
    public SongDaoImplFromFiles() {
        songs = new ArrayList<>();
        File[] files = srcDirectory.listFiles();
        for (File file : files) {
            AudioFile f;
            AudioHeader ah;
            Tag tag;
            try {
                f = AudioFileIO.read(file);
                tag = f.getTag();
                ah = f.getAudioHeader();
                
                songs.add(new Song(file.getName(), tag.getFirst(FieldKey.ARTIST), tag.getFirst(FieldKey.ALBUM),
                        Integer.valueOf(
                                (tag.getFirst(FieldKey.TRACK) != null && !tag.getFirst(FieldKey.TRACK).equals(""))
                                ? tag.getFirst(FieldKey.TRACK)
                                : "0"),
                        Integer.valueOf((tag.getFirst(FieldKey.YEAR) != null && !tag.getFirst(FieldKey.YEAR).equals(""))
                                ? tag.getFirst(FieldKey.YEAR)
                                : "0"),
                        tag.getFirst(FieldKey.GENRE), 
                        	convertSecondIntoTimeFormat(Integer.valueOf(ah.getTrackLength()))));

            } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Change second into HH:MM:SS
     * @param s - seconds
     * @return - String in format HH:MM:SS
     */
    private String convertSecondIntoTimeFormat(int s) {
    	int hours = (int) s / 3600;
        int remainder = (int) s - hours * 3600;
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
    	return songLength;
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
            if (containsIgnoreCase(song.getName(), name)) {
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
    
    /**
	 * Compare two String insensitive case.
	 * 
	 * @param src
	 *            - Source String
	 * @param what
	 *            - Comparing String
	 * @return true - when source String contains comparing String, otherwise false.
	 */
	 private boolean containsIgnoreCase(String src, String what) {
		final int length = what.length();
		if (length == 0)
			return true;

		final char firstLo = Character.toLowerCase(what.charAt(0));
		final char firstUp = Character.toUpperCase(what.charAt(0));

		for (int i = src.length() - length; i >= 0; i--) {
			final char ch = src.charAt(i);
			if (ch != firstLo && ch != firstUp)
				continue;

			if (src.regionMatches(true, i, what, 0, length))
				return true;
		}

		return false;
	}
}
