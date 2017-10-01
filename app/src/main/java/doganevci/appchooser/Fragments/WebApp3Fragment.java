package doganevci.appchooser.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import doganevci.appchooser.Fragments.BaseWebApp.WebAppSuperFragment;
import doganevci.appchooser.R;

public class WebApp3Fragment extends WebAppSuperFragment {

    // listens the battery receiver
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context ctxt, Intent intent) {

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            addNodeToWebViewWithJS(String.valueOf(level) + "%");
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().registerReceiver(mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public String getUrl() {
        return "http://doganevci.me/webapp3/";
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_web_app3;
    }

}
