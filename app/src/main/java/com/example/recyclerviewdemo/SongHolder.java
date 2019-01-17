package com.example.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SongHolder extends RecyclerView.ViewHolder {
  private TextView titleView;
  private TextView artistView;
  private TextView albumView;

  private Song song;

  SongHolder(@NonNull View itemView) {
    super(itemView);

    titleView = itemView.findViewById(R.id.title);
    artistView = itemView.findViewById(R.id.artist);
    albumView = itemView.findViewById(R.id.album);

    itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(v.getContext(), song.getTitle(), Toast.LENGTH_SHORT).show();
      }
    });
  }

  public void bindSong(Song song) {
    this.song = song;
    titleView.setText(song.getTitle());
    artistView.setText(song.getArtist());
    albumView.setText(song.getAlbum());
  }
}
