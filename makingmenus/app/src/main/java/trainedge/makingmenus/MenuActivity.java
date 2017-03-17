package trainedge.makingmenus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TextView tvSample= (TextView) findViewById(R.id.tvSample);
        tvSample.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_setting:
                //TODO: 16/03/2017  code for going to setting
                break;
            case R.id.action_feedback:
                //TODO: 16/03/2017  code for going to feedback
                break;
            case R.id.action_about:
                //TODO: 16/03/2017  code for going to about
                break;
            case R.id.action_exit:
                finish();// closes activity
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        PopupMenu popupMenu =  new PopupMenu(getApplicationContext(),v);
        popupMenu.inflate(R.menu.my_popupmenu);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_open:
                // TODO: 16/03/2017 code to open the item
                break;
        }
        return true;
    }
}
