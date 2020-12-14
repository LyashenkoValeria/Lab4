package com.example.lab4;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import name.ank.lab4.BibEntry;
import name.ank.lab4.Keys;


public abstract class ViewHolder extends RecyclerView.ViewHolder{

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    abstract void setKeys(BibEntry entry);

    public static class ViewHolderArt extends ViewHolder {

        public ViewHolderArt(@NonNull View itemView) {
            super(itemView);
        }
        TextView author;
        TextView title;
        TextView journal;
        TextView year;

        @Override
        void setKeys(BibEntry entry) {
            author = itemView.findViewById(R.id.art_author);
            author.setText(entry.getField(Keys.AUTHOR));
            title = itemView.findViewById(R.id.art_title);
            title.setText(entry.getField(Keys.TITLE));
            journal = itemView.findViewById(R.id.art_journal);
            journal.setText(entry.getField(Keys.JOURNAL));
            year = itemView.findViewById(R.id.art_year);
            year.setText(entry.getField(Keys.YEAR));
        }

    }

    public static class ViewHolderBook extends ViewHolder {

        public ViewHolderBook(@NonNull View itemView) {
            super(itemView);
        }
        TextView author;
        TextView title;
        TextView publisher;
        TextView year;

        @Override
        void setKeys(BibEntry entry) {
            author = itemView.findViewById(R.id.book_author);
            author.setText(entry.getField(Keys.AUTHOR));
            title = itemView.findViewById(R.id.book_title);
            title.setText(entry.getField(Keys.TITLE));
            publisher = itemView.findViewById(R.id.book_publisher);
            publisher.setText(entry.getField(Keys.PUBLISHER));
            year = itemView.findViewById(R.id.book_year);
            year.setText(entry.getField(Keys.YEAR));
        }

    }

    public static class ViewHolderInc extends ViewHolder {

        public ViewHolderInc(@NonNull View itemView) {
            super(itemView);
        }
        TextView author;
        TextView title;
        TextView booktitle;
        TextView year;

        @Override
        void setKeys(BibEntry entry) {
            author = itemView.findViewById(R.id.inc_author);
            author.setText(entry.getField(Keys.AUTHOR));
            title = itemView.findViewById(R.id.inc_title);
            title.setText(entry.getField(Keys.TITLE));
            booktitle = itemView.findViewById(R.id.inc_booktitle);
            booktitle.setText(entry.getField(Keys.BOOKTITLE));
            year = itemView.findViewById(R.id.inc_year);
            year.setText(entry.getField(Keys.YEAR));
        }

    }

    public static class ViewHolderInp extends ViewHolder{

        public ViewHolderInp(@NonNull View itemView) {
            super(itemView);
        }
        TextView author;
        TextView title;
        TextView booktitle;
        TextView year;

        @Override
        void setKeys(BibEntry entry){
            author = itemView.findViewById(R.id.inp_author);
            author.setText(entry.getField(Keys.AUTHOR));
            title = itemView.findViewById(R.id.inp_title);
            title.setText(entry.getField(Keys.TITLE));
            booktitle = itemView.findViewById(R.id.inp_booktitle);
            booktitle.setText(entry.getField(Keys.BOOKTITLE));
            year = itemView.findViewById(R.id.inp_year);
            year.setText(entry.getField(Keys.YEAR));

        }
    }

public static class ViewHolderMisc extends ViewHolder{

    public ViewHolderMisc(@NonNull View itemView) {
        super(itemView);
    }
    TextView author;
    TextView title;
    TextView howpublished;
    TextView year;

    @Override
    void setKeys(BibEntry entry){
        author = itemView.findViewById(R.id.misc_author);
        author.setText(entry.getField(Keys.AUTHOR));
        title = itemView.findViewById(R.id.misc_title);
        title.setText(entry.getField(Keys.TITLE));
        howpublished = itemView.findViewById(R.id.misc_howpublished);
        howpublished.setText(entry.getField(Keys.HOWPUBLISHED));
        year = itemView.findViewById(R.id.misc_year);
        year.setText(entry.getField(Keys.YEAR));
    }
}

    public static class ViewHolderTech extends ViewHolder {

        public ViewHolderTech(@NonNull View itemView) {
            super(itemView);
        }
        TextView author;
        TextView title;
        TextView booktitle;
        TextView year;

        @Override
        void setKeys(BibEntry entry) {
            author = itemView.findViewById(R.id.tech_author);
            author.setText(entry.getField(Keys.AUTHOR));
            title = itemView.findViewById(R.id.tech_title);
            title.setText(entry.getField(Keys.TITLE));
            booktitle = itemView.findViewById(R.id.tech_booktitle);
            booktitle.setText(entry.getField(Keys.BOOKTITLE));
            year = itemView.findViewById(R.id.tech_year);
            year.setText(entry.getField(Keys.YEAR));
        }

    }

    public static class ViewHolderUnp extends ViewHolder {

        public ViewHolderUnp(@NonNull View itemView) {
            super(itemView);
        }
        TextView author;
        TextView title;
        TextView year;
        TextView type;

        @Override
        void setKeys(BibEntry entry) {
            author = itemView.findViewById(R.id.unp_author);
            author.setText(entry.getField(Keys.AUTHOR));
            title = itemView.findViewById(R.id.unp_title);
            title.setText(entry.getField(Keys.TITLE));
            year = itemView.findViewById(R.id.unp_year);
            year.setText(entry.getField(Keys.YEAR));
            type = itemView.findViewById(R.id.unp_type1);
            type.setText(entry.getField(Keys.TYPE));
        }
    }
}
