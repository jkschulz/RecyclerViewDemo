package com.example.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddSongActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_song);
  }

  public void onSaveClicked(View view) {
    String title = ((EditText) findViewById(R.id.et_title)).getText().toString();
    String artist = ((EditText) findViewById(R.id.et_artist)).getText().toString();
    String album = ((EditText) findViewById(R.id.et_album)).getText().toString();
    SongList.INSTANCE.addSong((new Song(title, artist, album)));
    finish();
  }

  public void onCancelClicked(View view) {
    finish();
  }
}