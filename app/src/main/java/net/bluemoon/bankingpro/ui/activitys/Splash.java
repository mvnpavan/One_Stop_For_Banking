package net.bluemoon.bankingpro.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import net.bluemoon.bankingpro.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent bankingIntent = new Intent(Splash.this , BankingListActivity.class);
                startActivity(bankingIntent);
            }
        } , 4000);
    }
}
