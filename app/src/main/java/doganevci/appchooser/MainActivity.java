package doganevci.appchooser;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import doganevci.appchooser.Fragments.WebApp1Fragment;
import doganevci.appchooser.Fragments.WebApp2Fragment;
import doganevci.appchooser.Fragments.WebApp3Fragment;
import doganevci.appchooser.Fragments.WebApp4Fragment;
import doganevci.appchooser.JSBridge.JSBridge;
import doganevci.appchooser.Utils.myAnimationTrans;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;

    WebApp1Fragment Fragment1;
    WebApp2Fragment Fragment2;
    WebApp3Fragment Fragment3;
    WebApp4Fragment Fragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().hide();
        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);

    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        Fragment1=new WebApp1Fragment();
        Fragment2=new WebApp2Fragment();
        Fragment3=new WebApp3Fragment();
        Fragment4=new WebApp4Fragment();

        adapter.addFragment(Fragment1);
        adapter.addFragment(Fragment2);
        adapter.addFragment(Fragment3);
        adapter.addFragment(Fragment4);

        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setClipToPadding(false);
        mViewPager.setPageMargin(24);
        mViewPager.setPadding(48, 8, 48, 8);

        viewPager.setAdapter(adapter);
        mViewPager.setPageTransformer(true, new myAnimationTrans());
    }


    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }

    }

}
