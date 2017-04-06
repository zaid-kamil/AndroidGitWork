package trainedge.recyclerview_demo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by CISE on 03/04/2017.
 */

public class CommentHolder extends RecyclerView.ViewHolder {

     TextView tvUser;
     TextView tvCommentMsg;

    public CommentHolder(View itemView) {
        super(itemView);
        tvUser = (TextView) itemView.findViewById(R.id.tvUser);
        tvCommentMsg = (TextView) itemView.findViewById(R.id.tvCommentMsg);
    }
}
