package com.dicoding.picodiploma.submissionketiga;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class DataM implements Parcelable {
    private int id;
    private String judul;
    private String genre;
    private String popularity;
    private String tanggal;
    private String overview;
    private String photo;
    private String rating;
    private String language;
    private String URL = "https://image.tmdb.org/t/p/w780";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.judul);
        dest.writeString(this.genre);
        dest.writeString(this.popularity);
        dest.writeString(this.tanggal);
        dest.writeString(this.overview);
        dest.writeString(this.photo);
        dest.writeString(this.rating);
        dest.writeString(this.language);
    }

    public DataM(JSONObject object) {
        try {
            int id = object.getInt("id");
            String original_title = object.getString("original_title");
            String overview = object.getString("overview");
            String vote_average = object.getString("vote_average");
            String popularity = object.getString("popularity");
            String language = object.getString("original_language");
            String genre_ids = object.getString("genre_ids");
            String release_date = object.getString("release_date");
            String poster_path = URL + object.getString("poster_path");

            this.id = id;
            this.judul = original_title;
            this.overview = overview;
            this.rating = vote_average;
            this.popularity = popularity;
            this.language = language;
            this.genre = genre_ids;
            this.tanggal = release_date;
            this.photo = poster_path;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected DataM(Parcel in) {
        this.id = in.readInt();
        this.judul = in.readString();
        this.genre = in.readString();
        this.popularity = in.readString();
        this.tanggal = in.readString();
        this.overview = in.readString();
        this.photo = in.readString();
        this.rating = in.readString();
        this.language = in.readString();
    }

    public static final Parcelable.Creator<DataM> CREATOR = new Parcelable.Creator<DataM>() {
        @Override
        public DataM createFromParcel(Parcel source) {
            return new DataM(source);
        }

        @Override
        public DataM[] newArray(int size) {
            return new DataM[size];
        }
    };
}
