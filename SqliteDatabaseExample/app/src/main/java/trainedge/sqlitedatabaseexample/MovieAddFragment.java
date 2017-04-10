package trainedge.sqlitedatabaseexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MovieAddFragment extends Fragment {


    private EditText etMovieName;
    private EditText etMovieYear;
    private EditText etMovieRating;

    public MovieAddFragment() {
        // Required empty public constructor
    }


    //main method of a fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_add, container, false);
        //fragment layout object
        etMovieName = (EditText) view.findViewById(R.id.etMovieName);
        etMovieYear = (EditText) view.findViewById(R.id.etMovieYear);
        etMovieRating = (EditText) view.findViewById(R.id.etMovieRating);
        Button btnSave = (Button) view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDb();
            }
        });
        return view;
    }

    private void saveToDb() {
        String name = etMovieName.getText().toString().trim();
        String ratingStr = etMovieRating.getText().toString().trim();
        String yearStr = etMovieYear.getText().toString().trim();
        if (name.isEmpty() || ratingStr.isEmpty() || yearStr.isEmpty()) {
            Toast.makeText(getActivity(), "fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            MovieContract movieContract = new MovieContract(getActivity());
            movieContract.open();
            int rating = Integer.parseInt(ratingStr);
            int year = Integer.parseInt(yearStr);
            long rowNum = movieContract.addMovie(name, year, rating);
            if (rowNum != -1) {
                Toast.makeText(getActivity(), "success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
            }
        }
        //clear form
        etMovieName.setText("");
        etMovieRating.setText("");
        etMovieYear.setText("");
    }


}
