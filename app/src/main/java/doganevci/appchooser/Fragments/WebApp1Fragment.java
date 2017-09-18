package doganevci.appchooser.Fragments;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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

import static android.content.Context.SENSOR_SERVICE;

public class WebApp1Fragment extends Fragment implements SensorEventListener {


    private WebView  webView;
    private SensorManager sm;
    private Sensor accelerometer;
    private String appUrl="http://doganevci.me/webapp/";
    private ProgressBar myProgressBar;

    public WebApp1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_web_app1, container, false);
        rootView.setRotationY(180);


        sm=(SensorManager)getActivity().getSystemService(SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, 1000000);


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


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        webView.loadUrl("javascript:addNode(\"x:"+sensorEvent.values[0]+"-y:"+sensorEvent.values[1]+"-z:"+sensorEvent.values[2]+"\")");

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
