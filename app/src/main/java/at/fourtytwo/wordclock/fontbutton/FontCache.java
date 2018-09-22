package at.fourtytwo.wordclock.fontbutton;

import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by lukas on 11.04.2017.
 * See: http://stackoverflow.com/questions/16648190/how-to-set-a-particular-font-for-a-button-text-in-android
 */
public class FontCache {

    private static Hashtable<String, Typeface> fontCache = new Hashtable<>();

    public static Typeface getTypeface(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if(tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), "fonts/" + name);
            }
            catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}
