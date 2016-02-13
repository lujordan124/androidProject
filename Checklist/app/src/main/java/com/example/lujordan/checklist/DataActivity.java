package com.example.lujordan.checklist;

import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
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

        Bundle extra = getIntent().getExtras();
        ((TextView) findViewById(R.id.textViewData)).setText(extra.getString("task"));
        ((TextView) findViewById(R.id.textView2Data)).setText(extra.getString("description"));
        ((CheckBox) findViewById(R.id.checkBoxData)).setChecked(extra.getBoolean("finished"));

//        Intent intent = new Intent();
//        intent.putExtra("checked", ((CheckBox) findViewById(R.id.checkBoxData)).isChecked());
//        setResult(RESULT_OK, intent);
//        finish();
    }

}
