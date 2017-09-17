package doganevci.appchooser.Fragments;


import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import doganevci.appchooser.JSBridge.JSBridge;
import doganevci.appchooser.R;

import static android.content.Context.SENSOR_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebApp4Fragment extends Fragment {

    WebView  webView;
    JSBridge   theBridge;

    private String appUrl="http://doganevci.me/webapp4/";

    public WebApp4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_web_app4, container, false);



        webView = (WebView) rootView.findViewById(R.id.webview);
        Button btn= (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgToSend = "selammmm";
                webView.loadUrl("javascript:addNode(\""+msgToSend+"\")");
            }
        });


        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);




        webView.setWebChromeClient(new WebChromeClient() );
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

            }
        });


        theBridge = new JSBridge(getActivity(),webView);

        webView.addJavascriptInterface(theBridge, "JSBridgePlugin");
        webView.loadUrl(appUrl);

        return rootView;
    }

}
