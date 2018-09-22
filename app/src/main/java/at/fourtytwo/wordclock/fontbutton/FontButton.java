package at.fourtytwo.wordclock.fontbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import at.fourtytwo.wordclock.R;

/**
 * Created by lukas on 07.04.2017.
 */

public class FontButton extends android.support.v7.widget.AppCompatButton {
    public FontButton(Context context) {
        super(context);
    }

    public FontButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFontFromAttrib(attrs, context);

        invalidate();
        requestLayout();
    }

    public FontButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontFromAttrib(attrs, context);

        invalidate();
        requestLayout();
    }

    private void setFontFromAttrib(AttributeSet attrs, Context context) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontButton);
        String font = a.getString(R.styleable.FontButton_font_name);
        setCustomFont(font, context);

        a.recycle();
    }

    /**
     * Sets a font
     * @param font
     * @param context
     */
    public void setCustomFont(String font, Context context) {
        if(font == null)
            return;

        Typeface tf = FontCache.getTypeface(font, context);
        if(tf != null)
            setTypeface(tf);
    }

}
