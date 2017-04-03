

package trainedge.alltypeofmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ContextDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_demo);
        //object
        TextView tvDemoLabel = (TextView) findViewById(R.id.tvDemoLabel);
        //register it to context menu
        registerForContextMenu(tvDemoLabel);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context_demo, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_delete:
                break;
            case R.id.context_help:
                break;
            case R.id.context_info:
                break;
        }
        return true;
    }
}
