package com.mycompany.audiolibrary;

import java.io.File;
import java.util.List;

public interface SongDao {
	/**
	 * 
	 * @return List of all Songs. Never Null.
	 */
	List<Song> findAll();
	
	/**
	 * 
	 * @param Searched name
	 * @return List of Songs with the chosen name. Never Null.
	 */
	List<Song> findByName(String name);

	/**
	 * 
	 * @param album Searched album
	 * @return List of Songs with the chosen album. Never Null.
	 */
	List<Song> findByAlbum(String album);

	/**
	 * 
	 * @param interpret Searched interpret
	 * @return List of Songs with the chosen interpret. Never Null.
	 */
	List<Song> findByInterpret(String interpret);

	/**
	 * 
	 * @param genre Searched genre
	 * @return List of Songs with the chosen genre. Never Null.
	 */
	List<Song> findByGenre(String genre);

	/**
	 * 
	 * @param year Searched year
	 * @return Sorted List of Songs with the chosen year. Never Null.
	 */
	List<Song> findByYear(int year);

	/**
	 * 
	 * @return List of Strings all interprets. Never Null.
	 */
	List<String> getInterprets();

	/**
	 * 
	 * @return List of Strings all years. Never Null.
	 */
	List<String> getYears();

	/**
	 * 
	 * @return List of Strings all albums. Never Null.
	 */
	List<String> getAlbums();

	/**
	 * 
	 * @return List of Strings all genres. Never Null.
	 */
	List<String> getGenres();
	/**
	 * 
	 * @return Source Directory with sounds files.
	 */
	File getSrcDirectory();
	/**
	 * Set Directory source file.
	 * @param f - new source directory
	 */
	void setSrcDirectory(File f);
	/**
	 * Set/modify song
	 * @param s new Song
	 * @param index number of row
	 */
	void setSong(Song s, int index);
	
}
