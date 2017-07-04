package com.mycompany.audiolibrary;

import java.util.List;

public interface SongDao {
	/**
	 * 
	 * @return List of all Songs
	 */
	List<Song> findAll();
	/**
	 * 
	 * @param Searched name
	 * @return List of Songs with the chosen name  
	 */
	List<Song> findbyName(String name);
	/**
	 * 
	 * @param album Searched album
	 * @return List of Songs with the chosen album
	 */
	List<Song> findByAlbum(String album);
	/**
	 * 
	 * @param interpret Searched interpret
	 * @return List of Songs with the chosen interpret
	 */
	List<Song> findByInterpret(String interpret);
	/**
	 * 
	 * @param genre Searched genre
	 * @return List of Songs with the chosen genre
	 */
	List<Song> findByGenre(String genre);
	/**
	 * 
	 * @param year Searched year
	 * @return List of Songs with the chosen year
	 */
	List<Song> findByYear(int year);
	
}
