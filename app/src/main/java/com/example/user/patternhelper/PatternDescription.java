package com.example.user.patternhelper;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDescription extends AppCompatActivity {

    TextView patternDefinition = null;
    TextView patternDiagramDescription = null;
    TextView patternCode = null;
    ImageView patternImage = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_description);

        //region fields initialization
        patternDefinition = (TextView) findViewById(R.id.patternDescription);
        patternDiagramDescription = (TextView) findViewById(R.id.patternDiagramDescription);
        patternImage = (ImageView) findViewById(R.id.patternDiagram);
        patternCode = (TextView) findViewById(R.id.patternCode);
        //endregion

        Bundle arguments = getIntent().getExtras();
        String pattern = arguments.getString("pattern");

        //Определение паттерна
        String fullPatternName = pattern + "_definition";
        String fullPatternDescription = getString(getResources()
                .getIdentifier(fullPatternName,"string", getPackageName()));
        patternDefinition.setText(Html.fromHtml(fullPatternDescription));

        //Диаграма паттерна
        patternImage.setImageResource(getResources()
                .getIdentifier(pattern,"drawable",getPackageName()));

        //Описание паттерна
        String keyStringDiagramDescription = pattern + "_diagram_description";
        String valueStringDiagramDescription = getString(getResources()
                .getIdentifier(keyStringDiagramDescription,"string", getPackageName()));
        patternDiagramDescription.setText(Html.fromHtml(valueStringDiagramDescription));

        //Пример кода, реализующего паттерн
        String codeName = pattern + "_code";
        String patternCodeString = getString(getResources()
                .getIdentifier(codeName, "string", getPackageName()));

        //"Раскрашивание" кода
        CodeColor codeColor = new CodeColor(this);
        SpannableStringBuilder sp = codeColor.getColorCode(patternCodeString);
        patternCode.setText(sp);
    }
}
