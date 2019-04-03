package com.example.user.patternhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView mainListView = null;
    final String[] mainMenu = new String[]{
       "SOLID",
       "Паттерны"
    } ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById(R.id.mainListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,mainMenu);
        mainListView.setAdapter(adapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View itemClicked, int position,
                                    long id) {
                TextView itemClickedName = (TextView) itemClicked;
                String nameItem = itemClickedName.getText().toString();

                if(nameItem.equalsIgnoreCase(mainMenu[1]))
                    startActivity(new Intent(getApplicationContext(), PatternsActivity.class));

                if(nameItem.equalsIgnoreCase(mainMenu[0]))
                    startActivity(new Intent(getApplicationContext(), SolidActivity.class));
            }
        });
    }
}
