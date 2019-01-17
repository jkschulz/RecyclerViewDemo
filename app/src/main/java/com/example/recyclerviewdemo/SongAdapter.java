package com.example.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongHolder> {

  private List<Song> songs;

  SongAdapter() {
    this.songs = new ArrayList<>();
  }

  @NonNull
  @Override
  public SongHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.song_holder, parent, false);
    return new SongHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull SongHolder holder, int position) {
    // Bind the view holder to the item at given position.
    holder.bindSong(songs.get(position));
  }

  @Override
  public int getItemCount() {
    // Return the # of items in the list.
    return songs.size();
  }

  public void setSongs(List<Song> songs) {
    this.songs = songs;
    notifyDataSetChanged();
  }


}
