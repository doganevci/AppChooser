package doganevci.appchooser.Fragments;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import doganevci.appchooser.R;

import static android.content.Context.SENSOR_SERVICE;

public class WebApp1Fragment extends WebAppSuperFragment implements SensorEventListener {


    private SensorManager sensorManager;
    private Sensor accelerometer;

    // in constractor of the WebApp Fragments, which extends from WebAppSuperFragment,
    // you must set your webappurl and layout.
    //
    public WebApp1Fragment() {
        setLayout(R.layout.fragment_web_app1);
        setWebAppUrl("http://doganevci.me/webapp/");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        sensorManager =(SensorManager)getActivity().getSystemService(SENSOR_SERVICE);
        accelerometer= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, 1000000);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        addNodeToWebViewWithJS("x:"+sensorEvent.values[0]+"-y:"+sensorEvent.values[1]+"-z:"+sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
