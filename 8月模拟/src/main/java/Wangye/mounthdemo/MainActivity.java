package Wangye.mounthdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ViewPager mMyViewPager;
    /**
     * 圈子
     */
    private RadioButton mBtn1;
    /**
     * 朋友
     */
    private RadioButton mBtn2;
    /**
     * 我的
     */
    private RadioButton mBtn3;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mMyViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                Fragment fragment = null;

                switch (position) {

                    case 0:
                        fragment = new Fragment1();
                        break;
                    case 1:
                        fragment = new Fragment2();
                        break;
                    case 2:
                        fragment = new Fragment3();
                        break;

                }


                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });


    }

    private void initView() {
        mMyViewPager = (ViewPager) findViewById(R.id.myViewPager);
        mBtn1 = (RadioButton) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (RadioButton) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (RadioButton) findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                mMyViewPager.setCurrentItem(0);
                break;
            case R.id.btn2:
                mMyViewPager.setCurrentItem(1);
                break;
            case R.id.btn3:
                mMyViewPager.setCurrentItem(2);
                break;


        }


    }
}
