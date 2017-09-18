package doganevci.appchooser.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import doganevci.appchooser.JSBridge.JSBridge;
import doganevci.appchooser.R;

public class WebApp4Fragment extends Fragment {

    private WebView  webView;
    private JSBridge   theBridge;

    private String appUrl="http://doganevci.me/webapp4/";
    private ProgressBar myProgressBar;
    public WebApp4Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_web_app4, container, false);
        rootView.setRotationY(180);

        myProgressBar=(ProgressBar) rootView.findViewById(R.id.myProgressBar);

        webView = (WebView) rootView.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() );
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                myProgressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });

        // this is the javascript connection
        theBridge = new JSBridge(getActivity(),webView);

        webView.addJavascriptInterface(theBridge, "JSBridgePlugin");
        webView.loadUrl(appUrl);

        return rootView;
    }

}
