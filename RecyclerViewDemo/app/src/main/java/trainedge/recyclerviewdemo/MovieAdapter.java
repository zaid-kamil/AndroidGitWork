package trainedge.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CISE on 20/03/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Holder> {

    List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tvMovieName.setText(movies.get(position).name);
        holder.tvStudio.setText(movies.get(position).studio);
        holder.rbStars.setRating(movies.get(position).rating);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView tvMovieName;
        TextView tvStudio;
        RatingBar rbStars;

        public Holder(View itemView) {
            super(itemView);
            tvMovieName= (TextView) itemView.findViewById(R.id.tvMovieName);
            tvStudio= (TextView) itemView.findViewById(R.id.tvStudio);
            rbStars= (RatingBar) itemView.findViewById(R.id.rbStars);
        }
    }
}
