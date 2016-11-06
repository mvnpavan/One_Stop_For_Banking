package net.bluemoon.bankingpro.ui.activitys;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import net.bluemoon.bankingpro.R;
import net.bluemoon.bankingpro.browsing.SafeWebView;
import net.bluemoon.bankingpro.callbacks.SafeViewLoadCallback;
import net.bluemoon.bankingpro.utils.Constants;

/**
 * Created by mvnpavan on 29/01/16.
 */
public class BrowsingView extends BaseActivity implements SafeViewLoadCallback {


    private Context context;
    private FrameLayout browserHolder;
    private SafeWebView safeWebView;
    private ProgressBar progressBar;
    private int shortAnimTime;
    private String urlOfBank;
    private String nameOfBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browsingview);

        context = this;

        Intent intent = getIntent();
        if(intent!=null){
            urlOfBank = intent.getStringExtra(Constants.URL_IDENTIFIER);
            nameOfBank = intent.getStringExtra(Constants.BANK_IDENTIFIER);
        }

        browserHolder = (FrameLayout) findViewById(R.id.browseView);
        progressBar = (ProgressBar) findViewById(R.id.main_progress_bar);
        setupBrowser();
    }


    private void setupBrowser() {

        shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        updateProgress(Constants.PROGRESS_MAX);
        safeWebView = new SafeWebView(context);
        safeWebView.setSafeLoadCallback(this);
        browserHolder.removeAllViews();
        browserHolder.addView(safeWebView);
        safeWebView.loadUrl(urlOfBank);

    }

    @Override
    public synchronized void updateProgress(int progress) {
        if (progress > progressBar.getProgress()) {
            ObjectAnimator animator = ObjectAnimator.ofInt(progressBar, "progress", progress);
            animator.setDuration(shortAnimTime);
            animator.setInterpolator(new DecelerateInterpolator());
            animator.start();
        } else if (progress < progressBar.getProgress()) {
            ObjectAnimator animator = ObjectAnimator.ofInt(progressBar, "progress", 0, progress);
            animator.setDuration(shortAnimTime);
            animator.setInterpolator(new DecelerateInterpolator());
            animator.start();
        }

        if (progress < Constants.PROGRESS_MAX) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (safeWebView != null) {
            safeWebView.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (safeWebView != null) {
            safeWebView.onResume();
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(R.string.exit);
        String msg = context.getString(R.string.exit_msg_browsing);
        msg = msg.replace("%" , nameOfBank);

        builder.setMessage(msg);
        builder.setPositiveButton(R.string.dialog_button_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.dialog_button_negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }

}

