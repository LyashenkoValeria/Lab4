package com.example.lab4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import name.ank.lab4.BibEntry;
import name.ank.lab4.Types;


public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "myLogs";
    LayoutInflater inflater;
    List<BibEntry> entries;
    ViewHolder.ViewHolderArt viewHolderArt;
    ViewHolder.ViewHolderBook viewHolderBook;
    ViewHolder.ViewHolderInc viewHolderInc;
    ViewHolder.ViewHolderInp viewHolderInp;
    ViewHolder.ViewHolderMisc viewHolderMisc;
    ViewHolder.ViewHolderTech viewHolderTech;
    ViewHolder.ViewHolderUnp viewHolderUnp;


    Adapter(Context context, List<BibEntry> entries) {
        this.entries = entries;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view;
        switch (viewType) {
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book, parent, false);
                viewHolderBook = new ViewHolder.ViewHolderBook(view);
                return viewHolderBook;
            case 3:
                view = inflater.inflate(R.layout.incollection, parent, false);
                viewHolderInc = new ViewHolder.ViewHolderInc(view);
                return viewHolderInc;
            case 4:
                view = inflater.inflate(R.layout.inproceedings, parent, false);
                viewHolderInp = new ViewHolder.ViewHolderInp(view);
                return viewHolderInp;
            case 5:
                view = inflater.inflate(R.layout.mics , parent , false);
                viewHolderMisc = new ViewHolder.ViewHolderMisc(view);
                return viewHolderMisc;
            case 6:
                view = inflater.inflate(R.layout.techreport, parent, false);
                viewHolderTech = new ViewHolder.ViewHolderTech(view);
                return viewHolderTech;
            case 7:
                view = inflater.inflate(R.layout.unpublished, parent, false);
                viewHolderUnp = new ViewHolder.ViewHolderUnp(view);
                return viewHolderUnp;
            case 1:
            default:
                view = inflater.inflate(R.layout.article, parent, false);
                viewHolderArt = new ViewHolder.ViewHolderArt(view);
                return viewHolderArt;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder , int position) {
        Types currentType = entries.get(position).getType();
        Log.d(TAG, String.valueOf(currentType));
        switch (entries.get(position).getType()){
            case BOOK: viewHolderBook.setKeys(entries, position); break;
            case INCOLLECTION: viewHolderInc.setKeys(entries, position); break;
            case INPROCEEDINGS: viewHolderInp.setKeys(entries, position); break;
            case MISC: viewHolderMisc.setKeys(entries, position); break;
            case TECHREPORT: viewHolderTech.setKeys(entries, position); break;
            case UNPUBLISHED: viewHolderUnp.setKeys(entries, position); break;
            case ARTICLE:
            default: viewHolderArt.setKeys(entries, position); break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (entries.get(position).getType()) {
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
        return entries.size();
    }
}
