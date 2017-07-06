package com.mycompany.audiolibrary;

/**
 * Class Song make own object, which is supposed to represent one song with
 * attributes.
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
	 * @param name
	 *            String variable which represents name of song.
	 * @param interpret
	 *            String variable which represents song's interpret name.
	 * @param album
	 *            String variable which represents name of album from which song came.
	 * @param songNumber
	 *            Integer variable means number of song in an album. 
	 * @param year
	 *            Integer variable represents year of the song.
	 * @param genre
	 *            String variable means genders of song.
	 * @param length
	 *            String variable for length of song.
	 */
	public Song(String name, String interpret, String album, int songNumber, int year, String genre, String length) {
		this.name = name;
		this.interpret = interpret;
		this.album = album;
		this.songNumber = songNumber;
		this.year = year;
		this.genre = genre;
		this.length = length;
	}

	public Song() {}

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
	/**
	 * Set name
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Set interpret
	 * @param interpret new interpret
	 */
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}
	/**
	 * Set album
	 * @param album new album
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	/**
	 * Set song number
	 * @param songNumber new song number
	 */
	public void setSongNumber(int songNumber) {
		this.songNumber = songNumber;
	}
	/**
	 * Set year
	 * @param year new year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * Set genre
	 * @param genre new genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * set length
	 * @param length new length
	 */
	public void setLength(String length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((interpret == null) ? 0 : interpret.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + songNumber;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (interpret == null) {
			if (other.interpret != null)
				return false;
		} else if (!interpret.equals(other.interpret))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (songNumber != other.songNumber)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
