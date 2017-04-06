package trainedge.recyclerview_demo;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by XOXOX on 03/04/2017.
 */

public class CommentModel {
    String username;
    String msg;

    public CommentModel(DataSnapshot snapshot) {
        username=snapshot.child("user").getValue(String.class);
        msg=snapshot.child("msg").getValue(String.class);
    }
}
