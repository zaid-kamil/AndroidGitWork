package trainedge.animationdrawables;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean isAnimated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create object
        Button b1 = (Button) findViewById(R.id.b1);
        //add event listener
        b1.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        ImageView ivAnimate = (ImageView) findViewById(R.id.ivAnimate);
        ivAnimate.setBackgroundResource(R.drawable.my_animation);
        AnimationDrawable anim = (AnimationDrawable) ivAnimate.getBackground();
        if (!isAnimated) {
            anim.start();
            isAnimated = true;
        } else {
            anim.stop();
            isAnimated = false;
        }
    }
}
