package org.therrero.petagram4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        android.support.v7.widget.Toolbar miActionBar2 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(miActionBar2);
    }
    public void onClickBack(View view) {
        onBackPressed();
    }
}
