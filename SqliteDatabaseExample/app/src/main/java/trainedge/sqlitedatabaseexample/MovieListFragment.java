package trainedge.sqlitedatabaseexample;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieListFragment extends Fragment {


    public MovieListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        ListView lvMovies = (ListView) view.findViewById(R.id.lvMovies);
        MovieContract contract = new MovieContract(getActivity());
        contract.open();
        Cursor moviesCursor = contract.getAllMovies();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getActivity(), //context
                android.R.layout.simple_list_item_2, //default layout file with 2 textview
                moviesCursor, // cursor containing all movies
                new String[]{"name", "rating"}, // column names that we display in list
                new int[]{android.R.id.text1, android.R.id.text2},//default textview in the layout file
                0 // not important flag, so 0 is passed
        );
        lvMovies.setAdapter(adapter);
        return view;
    }

}
