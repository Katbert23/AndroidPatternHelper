package com.example.user.patternhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SolidActivity extends AppCompatActivity {

    ListView solidListView = null;
    final String[] solidList = new String[]{
            "Single responsibility",
            "Open-closed",
            "Liskov substitution",
            "Interface segregation",
            "Dependency inversion"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solid);

        solidListView = (ListView) findViewById(R.id.solidListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,solidList);
        solidListView.setAdapter(adapter);
    }
}
