package com.mycompany.audiolibrary;

/**
 * Class Song make own object, which is supposed to represent one song with attributes.
 */
public class Song {

	private String name;
	private String interpret;
	private String album;
	private int songNumber;
	private int year;
	private String genre;
	private String length;

	/**
	 * Constructor of song.
	 * 
	 * @param name String variable which represents name of song. Not null.
	 * @param interpret String variable which represents song's interpret name.
	 * @param album String variable which represents name of album from which song came.
	 * @param songNumber Integer variable means number of song in an album. Not null.
	 * @param year Integer variable represents year of  the song. Not null.
	 * @param genre String variable means genders of song.
	 * @param length String variable for length of song. 
	 */
	public Song(String name, String interpret, String album, int songNumber, int year, String genre, String length) {
		super();
		this.name = name;
		this.interpret = interpret == null ? "NaN" : interpret;
		this.album = album == null ? "NaN" : album;
		this.songNumber = songNumber;
		this.year = year;
		this.genre = genre == null ? "NaN" : genre;
		this.length = length == null ? "NaN" : length;
	}

	public Song() {
		super();
		this.name = "name";
		this.interpret = "interpret";
		this.album = "album";
		this.songNumber = 0;
		this.year = 1970;
		this.genre = "genre";
		this.length = "length";
	}

	/**
	 * Method to return name of song.
	 * 
	 * @return name. Not null.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to return interpret of song.
	 * 
	 * @return interpret. Not null.
	 */
	public String getInterpret() {
		return interpret;
	}

	/**
	 * Method to return an album of the song.
	 * 
	 * @return album. Not null.
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * Method to return number of song in an album.
	 * 
	 * @return number of song. Not null.
	 */
	public int getSongNumber() {
		return songNumber;
	}

	/**
	 * Method to return year of song.
	 * 
	 * @return year. Not null.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Method to return genre of song.
	 * 
	 * @return genre. Not null.
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Method to return length of song.
	 * 
	 * @return length. Not null.
	 */
	public String getLength() {
		return length;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Song)) return false;
		if (obj == this) return false;
		Song objSong = (Song) obj;
		if (!this.name.equals(objSong.name)) return false;
		if (!this.album.equals(objSong.album)) return false;
		if (!this.genre.equals(objSong.genre)) return false;
		if (!this.interpret.equals(objSong.interpret)) return false;
		if (!this.length.equals(objSong.length)) return false;
		if (this.year != objSong.year) return false;
		if (this.songNumber == objSong.songNumber) return false;
		return true;
	}

}
