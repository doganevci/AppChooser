package doganevci.appchooser.Fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import doganevci.appchooser.R;

public class WebApp3Fragment extends Fragment {

    private WebView  webView;
    private String appUrl="http://doganevci.me/webapp3/";
    private ProgressBar myProgressBar;
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context ctxt, Intent intent) {

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            webView.loadUrl("javascript:addNode(\""+String.valueOf(level) + "%"+"\")");

        }
    };

    public WebApp3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen

        View rootView = inflater.inflate(R.layout.fragment_web_app3, container, false);
        rootView.setRotationY(180);

        getActivity().registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

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
        webView.loadUrl(appUrl);

        return rootView;
    }

}
