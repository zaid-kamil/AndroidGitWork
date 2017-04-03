package trainedge.alltypeofmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_context_ex:
                Intent context_intent = new Intent(MainActivity.this, ContextDemoActivity.class);
                startActivity(context_intent);
                break;
            case R.id.action_pop_ex:
                Intent pop_intent = new Intent(MainActivity.this, PopupDemoActivity.class);
                startActivity(pop_intent);
                break;
            case R.id.action_dialog:
                Intent dialog_intent = new Intent(MainActivity.this, DialogDemoActivity.class);
                startActivity(dialog_intent);
                break;
            case R.id.action_actionmode:
                Intent action_intent = new Intent(MainActivity.this, ActionModeDemoActivity.class);
                startActivity(action_intent);
                break;
        }

        return true;
    }
}
