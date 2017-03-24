package trainedge.settingsdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, TextWatcher {

    private EditText etDefEmail;
    private Switch switchWifiOp;
    private Switch switchCloudSyncOp;
    private Button btnClearSettings;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //display back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //our code starts here
        //object creation

        etDefEmail = (EditText) findViewById(R.id.etDefEmail);
        switchWifiOp = (Switch) findViewById(R.id.switchWifiOp);
        switchCloudSyncOp = (Switch) findViewById(R.id.switchCloudSyncOp);
        btnClearSettings = (Button) findViewById(R.id.btnClearSettings);

        //SharedPref obj
        pref = getSharedPreferences("setting_pref", MODE_PRIVATE);

        //listener
        btnClearSettings.setOnClickListener(this);
        switchWifiOp.setOnCheckedChangeListener(this);
        switchCloudSyncOp.setOnCheckedChangeListener(this);
        etDefEmail.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        //clear settings
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        SharedPreferences.Editor editor = pref.edit();
        switch (buttonView.getId()) {
            case R.id.switchWifiOp:
                //code
                editor.putBoolean("wifi_option", isChecked);
                break;
            case R.id.switchCloudSyncOp:
                //code
                editor.putBoolean("cloud_option", isChecked);
                break;
        }
        editor.apply();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //keep it empty
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //keep it empty
    }

    @Override
    public void afterTextChanged(Editable s) {
        //saving email address
        SharedPreferences.Editor editor = pref.edit();
        String email = s.toString();
        if (email.isEmpty() && email.length() < 10 && !email.contains("@")) {
            etDefEmail.setError("Please give default email address");
            return;
        }
        editor.putString("def_email", email);
        editor.apply();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "Settings saved", Toast.LENGTH_SHORT).show();
    }
}
