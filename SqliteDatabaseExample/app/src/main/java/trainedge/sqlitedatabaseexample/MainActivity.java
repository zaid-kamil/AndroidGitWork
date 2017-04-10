package trainedge.sqlitedatabaseexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    displayListFragment(getSupportFragmentManager());
                    return true;
                case R.id.navigation_dashboard:
                    displayAddFragment(getSupportFragmentManager());
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    private void displayListFragment(FragmentManager manager) {
        MovieListFragment fragment = new MovieListFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        //animation optional
        transaction.setCustomAnimations(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
        //end
        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }

    private void displayAddFragment(FragmentManager manager) {
        MovieAddFragment fragment = new MovieAddFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        //animation optional
        transaction.setCustomAnimations(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
        //end
        transaction.replace(R.id.content, fragment);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayListFragment(getSupportFragmentManager());
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
