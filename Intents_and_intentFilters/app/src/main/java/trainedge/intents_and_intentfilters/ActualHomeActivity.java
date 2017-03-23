package trainedge.intents_and_intentfilters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActualHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_home);

        if (getIntent() != null && getIntent().getExtras() != null) {
            String user = getIntent().getStringExtra("trainedge.intents_and_intentfilters.key_user");
            String email = getIntent().getStringExtra("trainedge.intents_and_intentfilters.key_email");
            String pass = getIntent().getStringExtra("trainedge.intents_and_intentfilters.key_pass");
            TextView tvUser= (TextView) findViewById(R.id.tvUser);
            TextView tvEmail= (TextView) findViewById(R.id.tvEmail);
            TextView tvPass= (TextView) findViewById(R.id.tvPass);
            tvUser.setText(user);
            tvEmail.setText(email);
            tvPass.setText(pass);
        }

    }
}
