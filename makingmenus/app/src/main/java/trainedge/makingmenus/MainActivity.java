package trainedge.makingmenus;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.basic_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_help:
                //code
                break;
            case R.id.action_exit:
                // close activity and app
                finish();
                break;
            case R.id.action_dummy:

                break;
            case R.id.action_delete:
                showAlert();
                break;
        }
        return true;
    }

    private void showAlert(){
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Warning");
        builder.setMessage("This much coding will make you sleepy");
        builder.setPositiveButton("keep going", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //code to handle dialog button click
                Toast.makeText(MainActivity.this, "great", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }

}
