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


    private SensorManager sm;
    private Sensor accelerometer;

    public WebApp1Fragment() {
        setLayout(R.layout.fragment_web_app1);
        setWebAppUrl("http://doganevci.me/webapp/");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        sm=(SensorManager)getActivity().getSystemService(SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, 1000000);

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
