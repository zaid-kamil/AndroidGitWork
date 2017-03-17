package trainedge.preferencesex;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private TextView tvMessage;
    private EditText etUsername;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSave = (Button) findViewById(R.id.btnSave);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        etUsername = (EditText) findViewById(R.id.etUsername);

        //create object of sharedpref
        pref = getSharedPreferences("my_pref",MODE_PRIVATE);
        //read from pref inside onCreate()
        String username = pref.getString("user", "");
        if (!username.isEmpty()){
            etUsername.setText(username);
            tvMessage.setText("exists");
        }

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //get user input from EditText
        String username = etUsername.getText().toString();
        //validate
        if (username.isEmpty()){
            etUsername.setError("enter username");
            return;
        }
        //create editor object
        SharedPreferences.Editor editor = pref.edit();
        //put value inside pref using a unique key
        //here user is unique key and username is value
        editor.putString("user",username);
        //save changes into file
        editor.apply();
        tvMessage.setText("saved");

    }
}
