package com.mycompany.audiolibrary;

/**
 * Class Song make own object, which is supposed to represent
 * one song with atributes.
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
     * Construktor of song.
     * @param name String variable which represents name of song. Not null.
     * @param interpret String variable which represents song's interpret name.
     * @param album String variable which represents name of album from which song came.
     * @param songNumber Int variable means number of song in an album. Not null.
     * @param year Int variable represents year of relase the song. Not null.
     * @param genre String variable means gendre of song.
     * @param length String variable for length of song.
     */
	public Song(String name, String interpret, String album, int songNumber, int year, String genre, String length) {
		super();
		this.name=name;
		if(interpret==null) {
		this.interpret = "NaN";
		}else {
		this.interpret = interpret;
		}
		if(album==null) {
			this.album = "NaN";
		}else {
			this.album = album;
		}
		this.songNumber = songNumber;
		this.year = year;
		if(genre==null) {
			this.genre = "NaN";
		}else {
			this.genre = genre;
		}
		if(length==null) {
			this.length = "NaN";
		}else {
			this.length = length;
		}
	}

	public Song() {
		super();
		this.name="name";
		this.interpret = "interpret";
		this.album = "album";
		this.songNumber = 0;
		this.year = 1970;
		this.genre = "genre";
		this.length = "length";
	}

    /**
     * Metod to return name of song.
     * @return name. Not null.
     */
	public String getName() {
		return name;
	}

    /**
     * Metod to return interpret of song.
     * @return interpret. Not null.
     */
	public String getInterpret() {
		return interpret;
	}

    /**
     * Metod to return an album of the song.
     * @return album. Not null.
     */
	public String getAlbum() {
		return album;
	}

    /**
     * Metod to return number of song in an album.
     * @return sumber of song. Not null.
     */
	public int getSongNumber() {
		return songNumber;
	}

    /**
     * Metod to return year of song.
     * @return year. Not null.
     */
	public int getYear() {
		return year;
	}
    /**
     * Metod to return genre of song.
     * @return genre. Not null.
     */
	public String getGenre() {
		return genre;
	}

    /**
     * Metod to return length of song.
     * @return lenth. Not null.
     */
	public String getLength() {
		return length;
	}
	
	
}
