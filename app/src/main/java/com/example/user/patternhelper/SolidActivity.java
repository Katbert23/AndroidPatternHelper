package com.example.user.patternhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class SolidActivity extends AppCompatActivity {

    ListView solidListView = null;
    Map<String, String> SolidRusEnNames = new HashMap<String, String>();
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

        SolidRusEnNames.put("Принцип единственной ответственности", "single_responsibility");
        SolidRusEnNames.put("Принцип открыт-закрыт", "open_closed");
        SolidRusEnNames.put("Принцип подстановки Барбары Лисков", "liskov_substitution");
        SolidRusEnNames.put("Принцип разделения интерфейса", "interface_segregation");
        SolidRusEnNames.put("Принцип инверсии зависимостей", "dependency_inversion");

        String[] solidList = new String[SolidRusEnNames.size()];
        int index = 0;
        for(Map.Entry<String, String> entry : SolidRusEnNames.entrySet()){
            solidList[index] = entry.getKey();
            index++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,solidList);
        solidListView.setAdapter(adapter);

        solidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked,
                                    int position, long id) {
                TextView iClickedName = (TextView) itemClicked;
                String namePrinciple = iClickedName.getText().toString();

                Intent intent = new Intent(getApplicationContext(), SolidDescription.class);
                intent.putExtra("principle", SolidRusEnNames.get(namePrinciple));
                startActivity(intent);
            }
        });

    }
}
