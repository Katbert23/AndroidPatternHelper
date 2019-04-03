package com.example.user.patternhelper;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeColor {
    String originalCode = null;
    Context context = null;

    int keywordColor;
    //region String[] keywords
    String[] keywords = new String[]
            {
                    "new ",
                    "class ",
                    "public ",
                    "private ",
                    "protected ",
                    "abstract ",
                    "interface ",
                    "this.",
                    "void ",
                    "int ", "double ",
                    "string ",
                    "virtual ",
                    "override ",
                    "get ", "get;",
                    "set ", "set;",
                    "foreach ",
                    "in ",
                    "static",
                    "null", "return", "volatile", "if ", "lock", "object", "base."

            };
    //endregion

    int serviceColor;
    //region String[] serviceWords
    String[] serviceWords = new String[]
            {
                    "Console", "Program", "ArrayList",
                    "Context",
                    "IStrategy", "ConcreteStrategyA", "ConcreteStrategyB",
                    "IObservable", "ConcreteSubject", "ConcreteObserver", "IObserver", "ConcreteObservable",
                    "Client", "ConcreteFactory1", "ConcreteFactory2", "ProductA ", "ProductB ",
                    "AbstractFactory", "AbstractProductA", " AbstractProductB", "ProductA1",
                    "ProductA2", "ProductB1", " ProductB2",
                    "Creator", "Product", "ConcreteCreator", "ConcreteProduct",
                    "Singleton",
                    "Facade", "SubSystemA", "SubSystemB", "SubSystemC",
                    "Adaptee", "Adapter", "Target",
                    "Component", "Decorator", "ConcreteDecorator", "ConcreteDecoratorA", "ConcreteDecoratorB",
                    "Beverage", "Mocha", "Whip", "Espresso", "CondimentDecorator", "ConcreteComponent"
            };
    //endregion

    int textColor;
    String patText = "\".*\"";

    int commentColor;
    String patComment = "//.*";

    public CodeColor(Context context)
    {
        this.context = context;
        keywordColor = ContextCompat.getColor(context,R.color.keywordColor);
        serviceColor = ContextCompat.getColor(context,R.color.serviceColor);
        textColor = ContextCompat.getColor(context,R.color.textColor);
        commentColor = ContextCompat.getColor(context, R.color.commentColor);
    }
    public SpannableStringBuilder getColorCode(String originalCode)
    {
        this.originalCode = originalCode;
        SpannableStringBuilder sp = new SpannableStringBuilder(originalCode);
        sp = getColorBlockCode(sp, keywords, keywordColor);
        sp = getColorBlockCode(sp, serviceWords, serviceColor);
        String[] text = new String[]{patText};
        sp = getColorBlockCode(sp,text,textColor);
        text = new String[]{patComment};
        sp = getColorBlockCode(sp,text,commentColor);

        return sp;
    }


    private SpannableStringBuilder getColorBlockCode(SpannableStringBuilder ssb,
                                                     String[] words, int wordColor)
    {
        SpannableStringBuilder sp = ssb;
        for(int i = 0; i < words.length; i++)
        {
            Pattern p = Pattern.compile(words[i]);
            Matcher matcher = p.matcher(originalCode);

            while(matcher.find())
            {
                ForegroundColorSpan span = new ForegroundColorSpan(wordColor);
                sp.setSpan(
                        span, matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                );
            }
        }
        return  sp;
    }

}
