package trainedge.howgitworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
    Button b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        b4= (Button) findViewById(R.id.b4);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i4=new Intent(Main4Activity.this,MainActivity.class);
        startActivity(i4);
    }
}
