package de.blau.android.util;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;

/**
 * 
 * @see http://stackoverflow.com/questions/3083627/android-reference-the-value-of-an-attribute-in-the-currently-applied-theme-fro/3679026#3679026
 *
 */
public final class ThemeUtils {
    // Prevent instantiation since this is a utility class
    private ThemeUtils() {}

   /**
    * Returns the color value of the style attribute queried.
    *
    * <p>The attribute will be queried from the theme returned from {@link Context#getTheme()}.</p>
    *
    * @param context the caller's context
    * @param attribResId the attribute id (i.e. R.attr.some_attribute)
    * @param defaultValue the value to return if the attribute does not exist
    * @return the color value for the attribute or defaultValue
    */
    public static int getStyleAttribColorValue(final Context context, final int attribResId, final int defaultValue) {
        final TypedValue tv = new TypedValue();
        final boolean found = context.getTheme().resolveAttribute(attribResId, tv, true);
        return found ? tv.data : defaultValue;
    }
    
    public static int getResIdFromAttribute(final Context context,final int attr)
    {
    	if(attr==0) {
    		Log.d("ThemeUtils", "getResIdFromAttribute attr zero");
    		return 0;
    	}
    	final TypedValue typedvalueattr=new TypedValue();
    	if (!context.getTheme().resolveAttribute(attr,typedvalueattr,true)) {
    		Log.d("ThemeUtils", "getResIdFromAttribute attr "+ attr + " not found");
    		return 0;
    	}
    	return typedvalueattr.resourceId; 
    }
}