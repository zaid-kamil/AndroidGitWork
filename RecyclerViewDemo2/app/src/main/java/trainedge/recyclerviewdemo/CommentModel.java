package trainedge.recyclerviewdemo;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by CISE on 03/04/2017.
 */

class CommentModel {
    String username;
    String msg;

    public CommentModel(DataSnapshot dataSnapshot) {
        this.username = dataSnapshot.child("user").getValue(String.class);
        this.msg = dataSnapshot.child("msg").getValue(String.class);
    }
}
