package com.example.user.patternhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternsActivity extends AppCompatActivity {

    ListView patternsListView = null;

    Map<String, String> patternRusEnNames = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patterns);

        patternsListView = (ListView) findViewById(R.id.patternsListView);

        patternRusEnNames.put("Стратегия", "strategy");
        patternRusEnNames.put("Наблюдатель", "observer");
        patternRusEnNames.put("Декоратор", "decorator");
        patternRusEnNames.put("Абстрактная фабрика", "abstract_factory");
        patternRusEnNames.put("Одиночка", "singleton");
        patternRusEnNames.put("Команда", "command");
        patternRusEnNames.put("Адаптер", "adapter");
        patternRusEnNames.put("Фасад", "facade");
        patternRusEnNames.put("Фабричный метод", "factory_method");
        patternRusEnNames.put("Итератор", "iterator");
        patternRusEnNames.put("Компоновщик", "composite");
        patternRusEnNames.put("Состояние", "state");
        patternRusEnNames.put("Заместитель", "proxy");
		patternRusEnNames.put("Мост", "bridge");
        patternRusEnNames.put("Шаблонный метод", "template_method");
        patternRusEnNames.put("Строитель", "builder");
        patternRusEnNames.put("Прототип", "prototype");
		patternRusEnNames.put("Приспособленец", "flyweight");
		patternRusEnNames.put("Цепочка обязанностей", "chain_of_responsibility");
		patternRusEnNames.put("Интерпретатор", "interpretator");
		patternRusEnNames.put("Посредник", "Mediator");

        String[] patternsList = new String[patternRusEnNames.size()];
        int index = 0;
        for(Map.Entry<String, String> entry : patternRusEnNames.entrySet()){
            patternsList[index] = entry.getKey();
            index++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,patternsList);
        patternsListView.setAdapter(adapter);

        patternsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked,
                                    int position, long id) {
                TextView itemClickedName = (TextView) itemClicked;
                String namePattern = itemClickedName.getText().toString();

                Intent intent = new Intent(getApplicationContext(), PatternDescription.class);
                intent.putExtra("pattern", patternRusEnNames.get(namePattern));
                startActivity(intent);
            }
        });
    }
}
