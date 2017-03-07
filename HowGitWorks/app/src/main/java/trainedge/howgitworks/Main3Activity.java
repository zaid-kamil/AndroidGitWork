package trainedge.howgitworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b3= (Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i3=new Intent(Main3Activity.this,Main4Activity.class);
        startActivity(i3);
    }
}
