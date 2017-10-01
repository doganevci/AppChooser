package doganevci.appchooser.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import doganevci.appchooser.JSBridge.JSBridge;
import doganevci.appchooser.R;

// Extend from this class to add to your fragment
// a webview with jsbridge
//
//Use  setWebAppUrl and setLayout methods in your contructor.

public class WebAppSuperFragment extends Fragment {


    private WebView  webView; // webview for a webapp
    private String appUrl;    // webapplication's url
    private ProgressBar webViewProgressBar;  // progressbar when loading waiting time
    private int webAppNativeLayout=-1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(appUrl==null)
            Log.e("WebApp initilize error:","Url must be set!");

        if(webAppNativeLayout==-1)
            Log.e("WebApp initilize error:","webAppNativeLayout must be set!");

        return initilizeWebApp(inflater,container);
    }

    //Sets the webapps url
    public void setWebAppUrl(String url)
    {
        appUrl=url;
    }

    // sets the layout covers the webapp
    public void setLayout(int layout)
    {
        webAppNativeLayout =layout;
    }


    // This method initilize the webview for Javascript bridge and loading interface
    // automaticly calling
    private View initilizeWebApp(LayoutInflater inflater,ViewGroup container)
    {


        View rootView = inflater.inflate(webAppNativeLayout, container, false);
        rootView.setRotationY(180);
        webViewProgressBar =(ProgressBar) rootView.findViewById(R.id.myProgressBar);

        webView = (WebView) rootView.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() );
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                webViewProgressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });

        JSBridge theBridge = new JSBridge(getActivity(),webView);
        webView.addJavascriptInterface(theBridge, "JSBridgePlugin");  // For JavaScript Bridge  WebView -> NativeApp

        webView.loadUrl(appUrl);

        return rootView;
    }

    // Send string to Webview app
    // Bridge NativeApp -> WebApp
    public void addNodeToWebViewWithJS(String str)
    {
        webView.loadUrl("javascript:addNode(\""+str+"\")");
    }

}
