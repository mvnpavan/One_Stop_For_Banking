package net.bluemoon.bankingpro.ui.activitys;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import net.bluemoon.bankingpro.R;
import net.bluemoon.bankingpro.ui.fragments.SettingsFragment;
import net.bluemoon.bankingpro.utils.Constants;
import net.bluemoon.bankingpro.utils.utils;


/**
 * Created by mvnpavan on 30/01/16.
 */
public class Settings extends BaseActivity {

    private Context context;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_settings);

        context = this;

        toolbar = (Toolbar) findViewById(R.id.toolbar_settings);
        toolbar.setTitle(R.string.settings);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.settings_rating:
                utils.openAppInPlayStore(context, Constants.PAID_BUNDLE_ID);
                break;
            case R.id.settings_feedback:
                utils.feedbackMail(context);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }


}
