package trainedge.recyclerview_demo;

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

    //also a constructor
    List<CommentModel> commentList;

    public CommentAdapter(List<CommentModel> commentList) {
        this.commentList = commentList;
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=((LayoutInflater)parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.simple_comment_item,parent,false);

        return new CommentHolder(v);

    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        //databinding
        CommentModel model = commentList.get(position); //ctrl + alt + v
        holder.tvUser.setText(model.username);
        holder.tvCommentMsg.setText(model.msg);

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
