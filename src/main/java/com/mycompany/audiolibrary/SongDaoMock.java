package com.mycompany.audiolibrary;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SongDaoMock implements SongDao {

	private List<Song> songs;
	
	public SongDaoMock() {
		songs = new ArrayList<>();
		songs.add(new Song("Motor", "Corko", "Húko", 12, 1999, "speed metal", "12:12"));
		songs.add(new Song("Netuší", "Lopata", "Ostrava", 12, 2015, "slow metal", "16:33"));
		songs.add(new Song("Vyprchává", "Nikoto", "Assembly", 12, 2014, "pop", "3:13"));
		songs.add(new Song("Maybe", "Heyja", "Húko", 6, 1999, "speed metal", "4:50"));
		songs.add(new Song("Despacito", "Lusi", "WhAt", 3, 2017, "pop", "4:51"));
		songs.add(new Song("Kdo to ví?", "Kura", "Makeš", 2, 2012, "rock", "5:40"));
		songs.add(new Song("Posel", "Mezinkoš", "Makeš", 3, 2017, "rock", "4:13"));
		songs.add(new Song("Neruš", "basket", "kRál", 1, 1999, "k-pop", "4:11"));
		songs.add(new Song("Never", "Mezinkoš", "Makeš", 3, 2017, "rock", "3:13"));
		songs.add(new Song("Koktejl", "Bunda", "Molez", 1, 2015, "rap", "6:24"));
		songs.add(new Song("Hruza", "aDěs", "Makeš", 3, 2017, "rock", "7:31"));
		songs.add(new Song(
				"Tento text má strašlivě dlouhý důvod ke své existenci, ale to je na jiné povídaní. Chcete ho slyšet? Tak tedy dobře... Slyšte slyšte - přichází Mistr Bard. Byl nebyl jeden svět, kde existoval mír, ale nebyl to jen takový mír... Exitovali toitž roboti. Ti se měli rádi - dokud byly v aréně. Mlátili se a ničili, až hrůza. Ale všichni byly spojeni a tak byl na světě mír. WIN-WIN.",
				"Mr.Robot", "Robots", 3, 2017, "robotic", "23:59:55"));
		for (int i = 0; i < 20; i++) {
			songs.add(new Song("song" + i, "já 1", "Moje boží album", i + 1, 2017, "rock", "00:00"));
		}

		for (int i = 0; i < 50; i++) {
			songs.add(new Song("longsongs", "interpret" + i, "test", 1, 2017, "rock", "00:00"));
		}
		songs.add(new Song("BABYMETAL - ギミチョコ！！-", "オフィシャルサイト", "Toy's Factory", 12, 2015, "k-metal", "6:12"));
		songs.add(new Song("نيويورك", "القاعدة", "سبتمبر", 7, 2001, "explosiv metal", "2:12"));
		songs.add(new Song("Россия", "Путин", "свобода", 2, 2012, "techno", "36:16"));
		songs.add(new Song("Lálův song", "Franta Lála", "Lálovi Láloviny", 5, 2017, "rock", "3:13"));
		}

	@Override
	public List<Song> findAll() {
		return songs;
	}

	@Override
	public List<Song> findByAlbum(String album) {
		List<Song> pomSongs = new ArrayList<>();
		for (Song song : songs) {
			if (song.getAlbum().equals(album))
				pomSongs.add(song);
		}
		return pomSongs;
	}

	@Override
	public List<Song> findByInterpret(String interpret) {
		List<Song> pomSongs = new ArrayList<>();
		for (Song song : songs) {
			if (song.getInterpret().equals(interpret))
				pomSongs.add(song);
		}
		return pomSongs;
	}

	@Override
	public List<Song> findByGenre(String genre) {
		List<Song> pomSongs = new ArrayList<>();
		for (Song song : songs) {
			if (song.getGenre().equals(genre))
				pomSongs.add(song);
		}
		return pomSongs;
	}

	@Override
	public List<Song> findByYear(int year) {
		List<Song> pomSongs = new ArrayList<>();
		for (Song song : songs) {
			if (song.getYear() == year)
				pomSongs.add(song);
		}
		return pomSongs;
	}

	@Override
	public List<Song> findByName(String name) {
		if (name  != null)
			if (name.equals(""))
				return songs;
		List<Song> pomSongs = new ArrayList<>();
		for (Song song : songs) {
			if (containsIgnoreCase(song.getName(), name))
				pomSongs.add(song);
		}
		return pomSongs;
	}

	@Override
	public List<String> getInterprets() {
		List<String> pomStrings = new ArrayList<>();
		for (Song songs : songs) {
			if (!(pomStrings.contains(songs.getInterpret())))
				pomStrings.add(songs.getInterpret());
		}
		return pomStrings;
	}

	@Override
	public List<String> getYears() {
		List<Integer> pomStrings = new ArrayList<>();
		// add
		for (Song songs : songs) {
			if (!(pomStrings.contains(songs.getYear())))
				pomStrings.add(songs.getYear());
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
			if (!(pomStrings.contains(songs.getAlbum())))
				pomStrings.add(songs.getAlbum());
		}
		return pomStrings;
	}

	@Override
	public List<String> getGenres() {
		List<String> pomStrings = new ArrayList<>();
		for (Song songs : songs) {
			if (!(pomStrings.contains(songs.getGenre())))
				pomStrings.add(songs.getGenre());
		}
		return pomStrings;
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

	@Override
	public File getSrcDirectory() {
		return null;
	}

	@Override
	public void setSrcDirectory(File f) {
		return;
	}

}
