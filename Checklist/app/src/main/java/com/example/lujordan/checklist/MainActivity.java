package com.example.lujordan.checklist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        TableRow row1 = (TableRow) findViewById(R.id.tableRow1);
        TableRow row2 = (TableRow) findViewById(R.id.tableRow2);
        TableRow row3 = (TableRow) findViewById(R.id.tableRow3);

        addOnClickListener(row1, 0);
        addOnClickListener(row2, 1);
        addOnClickListener(row3, 2);

    }

    public void addOnClickListener(TableRow row, int num) {
        final int x = num;

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dataView = new Intent(getApplicationContext(), DataActivity.class);
                switch (x) {
                    case 0:
                        checkBox = (CheckBox) findViewById(R.id.checkbox1);
                        dataView.putExtra("task", ((TextView) findViewById(R.id.item1)).getText().toString());
                        dataView.putExtra("description", "Complete android checklist project by specified due date");
                        dataView.putExtra("finished", ((CheckBox) findViewById(R.id.checkbox1)).isChecked());
                        break;
                    case 1:
                        checkBox = (CheckBox) findViewById(R.id.checkbox2);
                        dataView.putExtra("task", ((TextView) findViewById(R.id.item2)).getText().toString());
                        dataView.putExtra("description", "Clear out the sink and put the dishes in the dishwasher.");
                        dataView.putExtra("finished", ((CheckBox) findViewById(R.id.checkbox2)).isChecked());
                        break;
                    case 2:
                        checkBox = (CheckBox) findViewById(R.id.checkbox3);
                        dataView.putExtra("task", ((TextView) findViewById(R.id.item3)).getText().toString());
                        dataView.putExtra("description", "Read the pages specified in the syllabus");
                        dataView.putExtra("finished", ((CheckBox) findViewById(R.id.checkbox3)).isChecked());
                        break;
                }

                startActivityForResult(dataView, 1);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.w("HI", "helloooooooooo");
        if (requestCode == 1) {
            Log.w("HI2", "teammmm: "+resultCode);

            if (resultCode == RESULT_OK) {
                Log.w("gg", "test");

                checkBox.setChecked(data.getBooleanExtra("checked", false));
//                checkBox.setChecked(true);
            }
        }
    }
}
