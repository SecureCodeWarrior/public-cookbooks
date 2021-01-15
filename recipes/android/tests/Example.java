import android.webkit.WebSettings;

class Example {
    void webviewSettings() {
        WebSettings settings = new WebSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setGeolocationEnabled(true);
        settings.setAllowContentAccess(true);
    }
}