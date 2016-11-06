package net.bluemoon.bankingpro.ui.activitys;

import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import net.bluemoon.bankingpro.application.BankingApplication;
import net.bluemoon.bankingpro.utils.PreferenceMangeHelper;

/**
 * Created by mvnpavan on 29/01/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        PreferenceMangeHelper preferenceMangeHelper = new PreferenceMangeHelper(this);
        if(preferenceMangeHelper.getSecureFlag()) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
        }
        BankingApplication application = (BankingApplication) getApplication();
        Tracker tracker = application.getDefaultTracker();
        tracker.setScreenName("Class~" + getLocalClassName());
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
        GoogleAnalytics.getInstance(this).dispatchLocalHits();
    }
}
