package com.dicoding.picodiploma.submissionketiga;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MovieViewModel extends ViewModel {

    private static final String API_KEY = "7c56e00359f5c13ed5413fa7650c047f";
    private MutableLiveData<ArrayList<DataM>> listMovie = new MutableLiveData<>();

    void setMovie(final String language){
        AsyncHttpClient client = new AsyncHttpClient();
        final ArrayList<DataM> listItems = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&language="+ language;

        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String( responseBody );
                    JSONObject responseObject = new JSONObject( result );
                    JSONArray list = responseObject.getJSONArray( "results" );
                    for (int i = 0; i < list.length(); i++) {
                        JSONObject film = list.getJSONObject( i );
                        DataM dataMovie = new DataM( film );
                        listItems.add(dataMovie);
                    }
                    listMovie.postValue(listItems);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    LiveData<ArrayList<DataM>> getMovie(){
        return listMovie;
    }
}
