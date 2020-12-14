package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;

import name.ank.lab4.BibDatabase;

public class MainActivity extends AppCompatActivity {
    public static final String ERROR = "Exception";
    private BibDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openDatabase();
        RecyclerView recyclerView = findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new Adapter(this, database);
        recyclerView.setAdapter(adapter);
    }

    public void openDatabase() {
        try (InputStreamReader reader = new InputStreamReader(getResources().openRawResource(R.raw.mixed)))
        {
            database = new BibDatabase(reader);
        }
        catch (IOException e) {
            Log.e(ERROR, "Unable to open this library");
        }
    }

    private RecyclerView.Adapter updateAdapter() {
        return new Adapter(this, database);
    }
}

