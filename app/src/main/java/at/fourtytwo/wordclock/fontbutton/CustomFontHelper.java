package at.fourtytwo.wordclock.fontbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import at.fourtytwo.wordclock.R;

/**
 * Created by lukas on 11.04.2017.
 * See: http://stackoverflow.com/questions/16648190/how-to-set-a-particular-font-for-a-button-text-in-android
 */

public class CustomFontHelper {

    /**
     * Sets a font on a textview based on the custom com.my.package:font attribute
     * If the custom font attribute isn't found in the attributes nothing happens
     * @param textview
     * @param context
     * @param attrs
     */
    public static void setCustomFont(TextView textview, Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontButton);
        String font = a.getString(R.styleable.FontButton_font_name);
        setCustomFont(textview, font, context);
        a.recycle();
    }

    /**
     * Sets a font on a textview
     * @param textview
     * @param font
     * @param context
     */
    public static void setCustomFont(TextView textview, String font, Context context) {
        if(font == null)
            return;

        Typeface tf = FontCache.getTypeface(font, context);
        if(tf != null)
            textview.setTypeface(tf);
    }

}
