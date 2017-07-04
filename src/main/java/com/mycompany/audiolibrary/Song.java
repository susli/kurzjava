package com.mycompany.audiolibrary;

public class Song {
	private String name;
	private String interpret;
	private String album;
	private int songNumber;
	private int year;
	private String genre;
	private String length;
	
	public Song(String name, String interpret, String album, int songNumber, int year, String genre, String length) {
		super();
		this.name=name;
		this.interpret = interpret;
		this.album = album;
		this.songNumber = songNumber;
		this.year = year;
		this.genre = genre;
		this.length = length;
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
	public String getName() {
		return name;
	}
	public String getInterpret() {
		return interpret;
	}
	public String getAlbum() {
		return album;
	}
	public int getSongNumber() {
		return songNumber;
	}
	public int getYear() {
		return year;
	}
	public String getGenre() {
		return genre;
	}
	public String getLength() {
		return length;
	}
	
	
}
