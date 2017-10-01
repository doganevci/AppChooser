package doganevci.appchooser.Fragments;

import doganevci.appchooser.Fragments.BaseWebApp.WebAppSuperFragment;
import doganevci.appchooser.R;

public class WebApp4Fragment extends WebAppSuperFragment {

    @Override
    public String getUrl() {
        return "http://doganevci.me/webapp4/";
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_web_app4;
    }
}
