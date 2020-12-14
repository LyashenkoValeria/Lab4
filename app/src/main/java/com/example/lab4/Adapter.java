package com.example.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import name.ank.lab4.BibDatabase;
import name.ank.lab4.BibEntry;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    LayoutInflater inflater;
    BibDatabase database;


    Adapter(Context context, BibDatabase database) {
        this.database = database;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        ViewHolder holder;
        switch (viewType) {
            case 2:
                view = inflater.inflate(R.layout.book, parent, false);
                holder = new ViewHolder.ViewHolderBook(view);
                return holder;
            case 3:
                view = inflater.inflate(R.layout.incollection, parent, false);
                holder = new ViewHolder.ViewHolderInc(view);
                return holder;
            case 4:
                view = inflater.inflate(R.layout.inproceedings, parent, false);
                holder = new ViewHolder.ViewHolderInp(view);
                return holder;
            case 5:
                view = inflater.inflate(R.layout.mics, parent, false);
                holder = new ViewHolder.ViewHolderMisc(view);
                return holder;
            case 6:
                view = inflater.inflate(R.layout.techreport, parent, false);
                holder = new ViewHolder.ViewHolderTech(view);
                return holder;
            case 7:
                view = inflater.inflate(R.layout.unpublished, parent, false);
                holder = new ViewHolder.ViewHolderUnp(view);
                return holder;
            case 1:
            default:
                view = inflater.inflate(R.layout.article, parent, false);
                holder = new ViewHolder.ViewHolderArt(view);
                return holder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BibEntry curEntry = database.getEntry(position);
        holder.setKeys(curEntry);
    }

    @Override
    public int getItemViewType(int position) {
        switch (database.getEntry(position).getType()) {
            case BOOK: return 2;
            case INCOLLECTION: return 3;
            case INPROCEEDINGS: return 4;
            case MISC: return 5;
            case TECHREPORT: return 6;
            case UNPUBLISHED: return 7;
            case ARTICLE:
            default: return 1;
        }
    }


    @Override
    public int getItemCount() {
        return database.size();
    }
}

