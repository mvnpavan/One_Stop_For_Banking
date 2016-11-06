package net.bluemoon.bankingpro.ui.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import net.bluemoon.bankingpro.R;

/**
 * Created by mvnpavan on 31/01/16.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

}
