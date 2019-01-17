package com.example.recyclerviewdemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ListActivity extends AppCompatActivity {

  private SongAdapter adapter = new SongAdapter();
  private static final String TAG = "ListActivity";
  private FloatingActionButton fab;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list);
    // Set up RecyclerView to display all songs.
    RecyclerView recyclerView = findViewById(R.id.list);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);
    recyclerView.setAdapter(adapter);
    adapter.setSongs(SongList.INSTANCE.getSongs());

    fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
        builder.setTitle("Add a new song");
        // Get the layout inflater
        LayoutInflater inflater = ListActivity.this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View dialogLayout = inflater.inflate(R.layout.dialog_add_song, null);
        builder.setView(dialogLayout);

        // Add the buttons
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            // User clicked Save button
            String title = ((EditText) dialogLayout.findViewById(R.id.et_title)).getText().toString();
            String artist = ((EditText) dialogLayout.findViewById(R.id.et_artist)).getText().toString();
            String album = ((EditText) dialogLayout.findViewById(R.id.et_album)).getText().toString();
            SongList.INSTANCE.addSong((new Song(title, artist, album)));
          }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
            // User cancelled the dialog.
            dialog.cancel();
          }
        });

        builder.create().show();
      }


    });
  }

  // Uncomment if using AddSongActivity.
//  public void startAddSongActivity(View view) {
//    Intent intent = new Intent(this, AddSongActivity.class);
//    startActivity(intent);
//  }
}
