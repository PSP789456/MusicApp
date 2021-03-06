package Test.musicapp.topsongs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import Test.musicapp.R;
import Test.musicapp.api.ApiService;
import Test.musicapp.api.Track;
import Test.musicapp.api.Tracks;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by W57069 on 2018-04-26.
 */

public class SongDetailsActivity extends AppCompatActivity {
    public static final String TRACK = "track";
    public static final String ARTIST = "artist";
    public static final String TRACK_ID = "track_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String track = intent.getStringExtra(TRACK);
        String artist = intent.getStringExtra(ARTIST);
        int trackId = intent.getIntExtra(TRACK_ID, 0);

        Toast.makeText(this, track, Toast.LENGTH_SHORT).show();

        getSupportActionBar().setTitle(track);
        getSupportActionBar().setSubtitle(artist);

        ApiService.getService().getTrack(trackId).enqueue(new Callback<Tracks>() {
            @Override
            public void onResponse(Call<Tracks> call, Response<Tracks> response) {
                Tracks tracks = response.body();
                if (tracks != null && tracks. track .size() > 0 ) {
                    showData(tracks. track .get( 0 ));
                }
            }

            @Override
            public void onFailure(Call<Tracks> call, Throwable t) {
                Toast.makeText(SongDetailsActivity.this, "Blad pobierania danych: " + t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();

            }


            private void showData(Track track) {
                TextView tvAlbum = findViewById(R.id. tvAlbum );
                TextView tvGenre = findViewById(R.id. tvGenre );
                TextView tvStyle = findViewById(R.id. tvStyle );
                TextView tvDescription = findViewById(R.id. tvDescription );
                tvAlbum.setText(track. strAlbum );
                tvGenre.setText(track. strGenre );
                tvStyle.setText(track. strStyle );
                tvDescription.setText(track. strDescriptionEN );
            }


        });
    }
}
