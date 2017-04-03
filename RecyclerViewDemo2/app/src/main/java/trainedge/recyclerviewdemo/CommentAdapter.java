package trainedge.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by CISE on 03/04/2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentHolder> {

    //we also need a constructor for this example
    List<CommentModel> commentList;
    //alt insert to add constructor


    public CommentAdapter(List<CommentModel> commentList) {
        this.commentList = commentList;
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = ((LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.simple_comment_item, parent, false);
        return new CommentHolder(row);
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        //databinding
        CommentModel model = commentList.get(position);
        holder.tvCommentUser.setText(model.username);
        holder.tvCommentMsg.setText(model.msg);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
