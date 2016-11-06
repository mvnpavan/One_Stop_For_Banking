package net.bluemoon.bankingpro.utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

/**
 * Created by mvnpavan on 30/01/16.
 */
public class utils {


    /**
     * Api to open application in play store app
     * @param context : App context
     * @param appId : unique id of app to open
     */
    public static void openAppInPlayStore(Context context , String appId){
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appId)));
        }
        catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appId)));
        }
    }

    /**
     * Api to find network availability in device
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Api to send feedback through email intent
     * @param context
     */
    public static void feedbackMail(Context context){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, Constants.DEV_MAIL_ID);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Banking App Feedback");

        context.startActivity(Intent.createChooser(intent, "Send Feedback"));
    }

}
