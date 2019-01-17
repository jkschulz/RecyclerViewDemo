package com.example.recyclerviewdemo;

public class Song {
  private final String title;
  private final String artist;
  private final String album;

  Song(String title, String artist, String album) {
    this.title = title;
    this.artist = artist;
    this.album = album;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public String getAlbum() {
    return album;
  }
}
