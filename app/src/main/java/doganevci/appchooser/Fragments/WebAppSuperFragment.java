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

public class WebAppSuperFragment extends Fragment {


    private WebView  webView;
    private String appUrl;
    private ProgressBar myProgressBar;
    private int thelayout;

    public WebAppSuperFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
        thelayout=layout;
    }


    // This method initilize the webview for Javascript bridge and loading interface
    private View initilizeWebApp(LayoutInflater inflater,ViewGroup container)
    {


        View rootView = inflater.inflate(thelayout, container, false);
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
