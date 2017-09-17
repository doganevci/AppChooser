package doganevci.appchooser.Fragments;


import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
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
import static android.hardware.SensorManager.SENSOR_DELAY_UI;


public class WebApp1Fragment extends Fragment implements SensorEventListener {


    WebView  webView;

    private SensorManager sm;
    private Sensor accelerometer;

    private String appUrl="http://doganevci.me/webapp/";

    public WebApp1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_web_app1, container, false);


        sm=(SensorManager)getActivity().getSystemService(SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, 1000000);



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


        webView.loadUrl(appUrl);


        return rootView;
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        webView.loadUrl("javascript:addNode(\"x:"+sensorEvent.values[0]+"-y:"+sensorEvent.values[1]+"-z:"+sensorEvent.values[2]+"\")");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
