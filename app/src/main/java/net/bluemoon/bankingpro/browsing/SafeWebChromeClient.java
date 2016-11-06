package net.bluemoon.bankingpro.browsing;

import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by mvnpavan on 23/01/16.
 */
public class SafeWebChromeClient extends WebChromeClient {


    private SafeWebView safeWebView;

    public SafeWebChromeClient(SafeWebView safeWebView) {
        this.safeWebView = safeWebView;
    }

    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(origin, callback);
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        safeWebView.updateProgress(newProgress);
    }
}
