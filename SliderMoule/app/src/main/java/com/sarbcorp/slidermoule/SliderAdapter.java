package com.sarbcorp.slidermoule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;

    public SliderAdapter(Context mContext){

        this.mContext = mContext;
    }

    //Array
    public int[] slide_images = {

            //Images here
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground
    };

    public String[] slide_headings = {

            //Headings Here

            "Heading 1",
            "Heading 2",
            "Heading 3",
            "Heading 4"
    };

    public String[] slide_desc =  {

            //Content Here

            "Content 1",
            "Content 2",
            "Content 3",
            "Content 4"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        View view = mLayoutInflater.inflate(R.layout.slider_view, container, false);

        ImageView mSlideImageView = (ImageView)view.findViewById(R.id.icons);
        TextView mSlideHeadingView = (TextView) view.findViewById(R.id.headings);
        TextView mSliderContentView = (TextView) view.findViewById(R.id.content);

        mSlideImageView.setImageResource(slide_images[position]);
        mSlideHeadingView.setText(slide_headings[position]);
        mSliderContentView.setText(slide_desc[position]);


        container.addView(view);

        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object){

        container.removeView((RelativeLayout)object);
    }
}
