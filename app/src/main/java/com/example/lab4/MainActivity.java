package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import name.ank.lab4.BibConfig;
import name.ank.lab4.BibDatabase;
import name.ank.lab4.BibEntry;

public class MainActivity extends AppCompatActivity {
    public static final String ERROR = "Exception";
    private BibDatabase database;
    List<BibEntry> entries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openDatabase();
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new Adapter(this, entries);
        recyclerView.setAdapter(adapter);
    }

    public void openDatabase() {
        try (InputStreamReader reader = new InputStreamReader(getResources().openRawResource(R.raw.mixed)))
        {
            database = new BibDatabase(reader);
            BibConfig cfg = database.getCfg();
            long entriesSize;
            if (cfg.strict) entriesSize = cfg.maxValid;
            else entriesSize = database.size();
            for (int i = 0; i < entriesSize; i++) {
                entries.add(database.getEntry(i));
            }
        } catch (IOException e) {
            Log.e(ERROR, "Unable to open this library");
        }
    }

    private RecyclerView.Adapter updateAdapter() {
        return new Adapter(this, entries);
    }
}

