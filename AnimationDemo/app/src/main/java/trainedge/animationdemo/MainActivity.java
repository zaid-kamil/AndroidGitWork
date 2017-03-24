package trainedge.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAnimate = (Button) findViewById(R.id.btnAnim);
        tvLabel = (TextView) findViewById(R.id.tvLabel);
        btnAnimate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        tvLabel.animate()
                .scaleX(1.5f)
                .scaleY(1.5f)
                .setDuration(1000);
        tvLabel.animate()
                .translationY(200f)
                .setInterpolator(new BounceInterpolator())
                .setDuration(1500);
        tvLabel.animate()
                .rotationX(360f)
                .alpha(0)
                .setInterpolator(new AnticipateOvershootInterpolator())
                .setDuration(1500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        tvLabel.animate()
                                .alpha(1)
                                .scaleX(0.5f)
                                .scaleY(0.5f)
                                .setDuration(1000);
                    }
                });
    }
}
