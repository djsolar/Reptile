package com.papapa.reptile.ui;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.papapa.reptile.R;
import com.papapa.reptile.fragment.MenuFragment;

public class BaseActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener{

    private boolean isSlidingMenu = false;
    private int mTitleRes;
    private SlidingMenu mSlidingMenu;

    public BaseActivity(int titleRes) {
        mTitleRes = titleRes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setTitle(mTitleRes);
        initSlidingMenu();
    }

    private void initSlidingMenu() {
        mSlidingMenu = new SlidingMenu(this);
        mSlidingMenu.setMode(SlidingMenu.LEFT);
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        mSlidingMenu.setBehindOffsetRes(R.dimen.frame_menu_left_width);
        mSlidingMenu.setShadowDrawable(R.drawable.shadow);
        mSlidingMenu.setShadowWidthRes(R.dimen.frame_menu_left_shadow);
        mSlidingMenu.setFadeDegree(0.35f);
        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        mSlidingMenu.setMenu(R.layout.sliding_menu_left);
        getSupportFragmentManager().beginTransaction().replace(R.id.menu_frame_left, MenuFragment.newInstance("zhou", "yiran")).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
