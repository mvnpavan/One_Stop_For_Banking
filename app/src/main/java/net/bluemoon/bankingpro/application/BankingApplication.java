package net.bluemoon.bankingpro.application;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import net.bluemoon.bankingpro.R;

/**
 * Created by mvnpavan on 30/01/16.
 */
public class BankingApplication extends Application {

    public static GoogleAnalytics analytics;
    public static Tracker mTracker;

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            analytics = GoogleAnalytics.getInstance(this);
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}
