package com.mycompany.audiolibrary;

import java.util.ArrayList;
import java.util.List;

public class SongDaoImp implements SongDao{

	List<Song> songs;
	
	public SongDaoImp() {
		songs = new ArrayList<>();
		songs.add(new Song());
		songs.add(new Song("IDK", "Corko", "Húko", 12, 1999, "speed metal", "12:12"));
		songs.add(new Song("Netuším", "Lopata", "Ostrava", 12, 2015, "slow metal", "16:33"));
		songs.add(new Song("IDK", "Nikoto", "Assembly", 12, 2014, "pop", "3:13"));
		songs.add(new Song("Možná", "Heyja", "Húko", 6, 1999, "speed metal", "4:50"));
		songs.add(new Song("Jako", "Despacito", "Lusi", 3, 2017, "pop", "4:51"));
		songs.add(new Song("Jako", "Kura", "Makeš", 2, 2012, "rock", "5:40"));
		songs.add(new Song("IDK", "Mezinkoš", "Makeš", 3, 2017, "rock", "4:13"));
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
		List<Song> pomSongs = new ArrayList<>();
		for (Song song : songs) {
			if (song.getName().equals(name))
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
		List<String> pomStrings = new ArrayList<>();
		for (Song songs : songs) {
			if (!(pomStrings.contains(String.valueOf(songs.getYear()))))
				pomStrings.add(songs.getInterpret());
		}
		return pomStrings;
	}

	@Override
	public List<String> getAlbums() {
		List<String> pomStrings = new ArrayList<>();
		for (Song songs : songs) {
			if (!(pomStrings.contains(songs.getAlbum())))
				pomStrings.add(songs.getInterpret());
		}
		return pomStrings;
	}

	@Override
	public List<String> getGenres() {
		List<String> pomStrings = new ArrayList<>();
		for (Song songs : songs) {
			if (!(pomStrings.contains(songs.getGenre())))
				pomStrings.add(songs.getInterpret());
		}
		return pomStrings;
	}

}
