package com.example.cas.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPortalActivity extends AppCompatActivity {

    EditText mUrl;
    EditText mName;
    Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mName = findViewById(R.id.edit_name);
        mUrl = findViewById(R.id.edit_url);
        mAddButton = findViewById(R.id.add_button);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("name",mName.getText().toString());
                intent.putExtra("url",mUrl.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
