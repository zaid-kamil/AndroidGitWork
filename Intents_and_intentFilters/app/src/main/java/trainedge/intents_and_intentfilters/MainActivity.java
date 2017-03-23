package trainedge.intents_and_intentfilters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUser;
    private EditText etEmail;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = (EditText) findViewById(R.id.etUser);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        Button btnSave = (Button) findViewById(R.id.btnSave);
        Button btnActuallySave = (Button) findViewById(R.id.btnActaullySave);

        btnActuallySave.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                fakeSave();
                break;
            case R.id.btnActaullySave:
                reallySave();
                break;
        }


    }

    private void reallySave() {
        //extract data from object
        String user = etUser.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        //validation
        //basic validation
        if (user.isEmpty()) {
            etUser.setError("Fill username");
            return;
        }
        if (email.isEmpty()) {
            etEmail.setError("Fill email");
            return;
        }
        if (password.isEmpty()) {
            etPass.setError("Fill password");
            return;
        }
        //end of basic validation

        //intent with data passing
        Intent realHomeIntent=new Intent(this,ActualHomeActivity.class);
        //put data into intent
        realHomeIntent.putExtra("trainedge.intents_and_intentfilters.key_user",user);
        realHomeIntent.putExtra("trainedge.intents_and_intentfilters.key_email",email);
        realHomeIntent.putExtra("trainedge.intents_and_intentfilters.key_pass",password);

        startActivity(realHomeIntent);
    }


    private void fakeSave() {
        //extract data from object
        String user = etUser.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        //validation
        //basic validation
        if (user.isEmpty()) {
            etUser.setError("Fill username");
            return;
        }
        if (email.isEmpty()) {
            etEmail.setError("Fill email");
            return;
        }
        if (password.isEmpty()) {
            etPass.setError("Fill password");
            return;
        }
        //end of basic validation
        Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
        //use the intent
        startActivity(homeIntent);
        //or
        //startActivity(new Intent(this,HomeActivity.class));
    }
}
