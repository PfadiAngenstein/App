package ch.pfadiangenstein;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Fragment;
import android.app.FragmentManager;
import android.widget.Toast;


public class MyWebViewFragment extends Fragment {

    ProgressDialog mProgress;
    Toast mToast;
    WebView webview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.web_fragment, container, false);

        Bundle bundle = getArguments();
        String url = bundle.getString("url");
        webview = (WebView) rootView.findViewById(R.id.webview1);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        mProgress = ProgressDialog.show(getActivity(), "Laden", "Bitte habe einen Augenblick Geduld");

        webview.loadUrl(url);

        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (mProgress.isShowing()) {
                    mProgress.dismiss();
                }
            }
        });



        return rootView;
    }

    /**
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            // wenn zurück-Button gedrückt und WebView kann zurück navigieren, gehe zurück
            webview.goBack();
            return true;
        } else {

        }
        return true;
    }
    **/

}


