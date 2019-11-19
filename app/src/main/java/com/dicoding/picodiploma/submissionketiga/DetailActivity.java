package com.dicoding.picodiploma.submissionketiga;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    TextView tvJudul;
    TextView tvPopularity;
    TextView tvTanggal;
    TextView tvOverview;
    ImageView imgCover;
    TextView tvRating;
    TextView tvLanguage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvJudul = findViewById(R.id.tv_judul);
        tvPopularity = findViewById(R.id.tv_popularity);
        tvTanggal = findViewById(R.id.tv_tanggal);
        tvOverview = findViewById(R.id.tv_deskripsi);
        imgCover = findViewById(R.id.img_photo);
        tvRating = findViewById(R.id.tv_rating);
        tvLanguage = findViewById(R.id.tv_language);

        DataM dataM = getIntent().getParcelableExtra(EXTRA_MOVIE);
        assert dataM != null;
        tvJudul.setText(dataM.getJudul());
        tvPopularity.setText(dataM.getPopularity());
        tvTanggal.setText(dataM.getTanggal());
        tvOverview.setText(dataM.getOverview());

        Glide.with(this)
                .load(dataM.getPhoto())
                .apply(new RequestOptions().override(450, 650))
                .into(imgCover);

        tvRating.setText(dataM.getRating());
        tvLanguage.setText(dataM.getLanguage());
    }
}
