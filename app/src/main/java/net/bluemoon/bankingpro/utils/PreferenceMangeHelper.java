package net.bluemoon.bankingpro.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by mvnpavan on 23/01/16.
 */
public class PreferenceMangeHelper {

    private final Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    public PreferenceMangeHelper(Context context) {
        this.context = context;
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
    }

    public boolean getBankingType(){
        return preferences.getBoolean(Constants.PREF_TYPE_BANKING, false);
    }

    public boolean getSecureFlag(){
        return preferences.getBoolean(Constants.SECURE_SCREEN , true);
    }

}
