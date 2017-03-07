package trainedge.howgitworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b2= (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i2=new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(i2);
    }
}
