package com.mycompany.audiolibrary;

import java.util.List;

public interface SongDao {

	List<Song> findAll();
	List<Song> findByAlbum(String album);
	List<Song> findByInterpret(String interpret);
	List<Song> findByGenre(String genre);
	List<Song> findByYear(int year);
	
}
