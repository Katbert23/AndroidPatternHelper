package com.example.user.patternhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class SolidDescription extends AppCompatActivity {

    TextView solidDescription;
    TextView antiSolidDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solid_description);

        solidDescription = (TextView) findViewById(R.id.solidDescription);
        solidDescription.setMovementMethod(new ScrollingMovementMethod());

        antiSolidDescription = (TextView) findViewById(R.id.antiSolidDescription);
        antiSolidDescription.setMovementMethod(new ScrollingMovementMethod());

        Bundle arguments = getIntent().getExtras();
        String principle = arguments.getString("principle");

        //Описание solid-принципа
        String fullPrincipleName = principle + "_description";
        String fullPrincipleDescription = getString(getResources()
                .getIdentifier(fullPrincipleName,"string", getPackageName()));
        solidDescription.setText(Html.fromHtml(fullPrincipleDescription));

        //Описание antisolid-принципа
        String fullAntiPrincipleName = principle + "_anti_description";
        String fullAntiPrincipleDescription = getString(getResources()
                .getIdentifier(fullAntiPrincipleName,"string", getPackageName()));
        antiSolidDescription.setText(Html.fromHtml(fullAntiPrincipleDescription));
    }
}


