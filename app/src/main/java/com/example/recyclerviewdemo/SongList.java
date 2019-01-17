package com.example.recyclerviewdemo;

import java.util.ArrayList;
import java.util.List;

// Singleton.
public class SongList {

  public static final SongList INSTANCE = new SongList();
  private List<Song> songs = new ArrayList<>();

  private SongList() {
    // Uncomment to populate singleton with test data.
//    for (int i = 0; i < 40; i++) {
//      songs.add(new Song("title" + i, "artist" + i, "album" + i));
//    }
  }

  public List<Song> getSongs() {
    return songs;
  }

  public void addSong(Song song) {
    songs.add(song);
  }
}
