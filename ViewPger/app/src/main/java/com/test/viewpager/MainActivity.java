package com.test.viewpager;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.test.viewpager.Utils.Constant;
import com.test.viewpager.Adapter.ViewPagerAdapter;

public class MainActivity extends Activity implements View.OnClickListener {

    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private TextView title;
    private int playmode = Constant.PLAY_MODE_CHILD;
    private int childID = -1;
    private Button btnBack,btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            playmode = extras.getInt(Constant.PLAY_MODE);
            childID = extras.getInt(Constant.ARG_CHILD_ID);
        }
        pager = (ViewPager)findViewById(R.id.viewPager);
        int margin = (int) 60;

        pager.setPadding(margin, 0, margin, 0);
        pager.setClipToPadding(false);
        pager.setPageMargin(0);

        adapter = new ViewPagerAdapter(this,playmode,childID);
        pager.setAdapter(adapter);

        title = (TextView)findViewById(R.id.textView1);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnStart = (Button)findViewById(R.id.btnMulai);
        btnBack.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnBack:
                finish();
                break;
            default:
                break;
        }
    }

}
