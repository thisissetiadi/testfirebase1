package com.test.viewpager.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.test.viewpager.R;
import com.test.viewpager.Entity.listPager;
import com.test.viewpager.Utils.Constant;
import java.util.ArrayList;
import java.util.List;


public class ViewPagerAdapter  extends PagerAdapter{
    private List<listPager> dtlist ;
    private Activity context;
    private View layout;
    private int playmode = Constant.PLAY_MODE_CHILD;
    private int childID = -1;
    public ViewPagerAdapter(Activity context) {
        this.context = context;
        dtlist = new ArrayList<listPager>();
        for (int i = 0; i < 6; i++) {
            listPager md = new listPager();
            md.setId(i+1);
            md.setName("MODEL "+ (i+1));
            if((i+1) == 1)
                md.setCover(R.drawable.test_1);
            else if((i+1) == 2)
                md.setCover(R.drawable.test_2);
            else if((i+1) == 3)
                md.setCover(R.drawable.test_3);
            else if((i+1) == 4)
                md.setCover(R.drawable.test_4);
            dtlist.add(md);
        }
    }
    public ViewPagerAdapter(Activity context,int playmode,int childID) {
        this.context = context;
        dtlist = new ArrayList<listPager>();
        this.playmode = playmode;
        this.childID = childID;
        for (int i = 0; i < 4; i++) {
            listPager md = new listPager();
            md.setId(i+1);
            md.setName("MODEL "+ (i+1));
            if((i+1) == 1)
                md.setCover(R.drawable.test_1);
            else if((i+1) == 2)
                md.setCover(R.drawable.test_2);
            else if((i+1) == 3)
                md.setCover(R.drawable.test_3);
            else if((i+1) == 4)
                md.setCover(R.drawable.test_4);
            dtlist.add(md);
        }
    }
    public void set(List<listPager> list) {
        this.dtlist = list;
        notifyDataSetChanged();
    }
    public listPager getItem(int position) {
        return this.dtlist.get(position);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return dtlist.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // TODO Auto-generated method stub
        return dtlist.get(position).getName();
    }
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == ((View) arg1);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = inflater.inflate(R.layout.model_item, null);
        ImageView img = (ImageView) layout.findViewById(R.id.imageView1);
        final listPager md = dtlist.get(position);
        img.setImageResource(md.getCover());
        ((ViewPager) container).addView(layout, 0);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });
        return layout;
    }

}
