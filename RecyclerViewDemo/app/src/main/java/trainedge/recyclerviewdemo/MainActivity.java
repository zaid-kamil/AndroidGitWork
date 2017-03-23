package trainedge.recyclerviewdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        RecyclerView rvList = (RecyclerView) findViewById(R.id.rvList);

        rvList.setLayoutManager(new LinearLayoutManager(this));

        rvList.setAdapter(new MovieAdapter(getMovieList()));

    }

    public List<Movie> getMovieList() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Moana", 5f, "Disney"));
        movies.add(new Movie("Kung fu Panda", 5f, "Dreamworks"));
        movies.add(new Movie("Star wars", 4.5f, "Disney"));
        movies.add(new Movie("Fast and Furious 7", 4f, "Universal"));
        movies.add(new Movie("Captain America :civil war", 5f, "marvel"));
        movies.add(new Movie("Moana", 5f, "Disney"));
        movies.add(new Movie("Kung fu Panda", 5f, "Dreamworks"));
        movies.add(new Movie("Star wars", 4.5f, "Disney"));
        movies.add(new Movie("Fast and Furious 7", 4f, "Universal"));
        movies.add(new Movie("Captain America :civil war", 5f, "marvel"));
        movies.add(new Movie("Moana", 5f, "Disney"));
        movies.add(new Movie("Kung fu Panda", 5f, "Dreamworks"));
        movies.add(new Movie("Star wars", 4.5f, "Disney"));
        movies.add(new Movie("Fast and Furious 7", 4f, "Universal"));
        movies.add(new Movie("Captain America :civil war", 5f, "marvel"));
        movies.add(new Movie("Logan",0,"Fox"));
        return movies;
    }
}
