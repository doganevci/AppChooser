package doganevci.appchooser;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import doganevci.appchooser.Fragments.WebApp1Fragment;
import doganevci.appchooser.Fragments.WebApp2Fragment;
import doganevci.appchooser.Fragments.WebApp3Fragment;
import doganevci.appchooser.Fragments.WebApp4Fragment;
import doganevci.appchooser.Utils.MyAnimationTrans;

import static android.support.v4.view.ViewPager.SCROLL_STATE_DRAGGING;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().hide();
        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager();
    }


    // Created 4 fragment for 4 webapps
    // initilize viewpager
    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        WebApp1Fragment Fragment1=new WebApp1Fragment();
        WebApp2Fragment Fragment2=new WebApp2Fragment();
        WebApp3Fragment Fragment3=new WebApp3Fragment();
        WebApp4Fragment Fragment4=new WebApp4Fragment();


        adapter.addFragment(Fragment1);
        adapter.addFragment(Fragment2);
        adapter.addFragment(Fragment3);
        adapter.addFragment(Fragment4);

        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setClipToPadding(false);

        mViewPager.setPageMargin(24);
        mViewPager.setPadding(48, 8, 48, 8);
        mViewPager.setRotationY(180);

        mViewPager.setAdapter(adapter);
        mViewPager.setPageTransformer(true, new MyAnimationTrans());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state!=SCROLL_STATE_DRAGGING)
                {
                    //mViewPager.setPageMargin(0);
                   // mViewPager.setPadding(0, 0, 0, 0);
                }
                else
                {


                }

            }
        });


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
