package com.example.listview;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

public class WearableListItemLayout extends LinearLayout implements WearableListView.OnCenterProximityListener {
    private ImageView mCircle;
    private TextView mName;

    private final float mFadeTextAlpha;
//    private final int mFadeCircleColor;
//    private final int mFadeChoosenColor;

    public WearableListItemLayout(Context context) {
        this(context, null);
    }

    public WearableListItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WearableListItemLayout(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        mFadeTextAlpha = 0.7f;
//        mFadeCircleColor = getResources().getColor(R.color.grey);
//        mFadeChoosenColor = getResources().getColor(R.color.blue);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mCircle = findViewById(R.id.circle);
        mName = findViewById(R.id.name);
    }

    @Override
    public void onCenterPosition(boolean animate) {
        mName.setAlpha(1f);
//        ((GradientDrawable) mCircle.getDrawable()).setColor(mFadeChoosenColor);
//        mCircle.setColorFilter(mFadeChoosenColor);
        mCircle.setColorFilter(ActivityCompat.getColor(getContext(), R.color.blue));
    }

    @Override
    public void onNonCenterPosition(boolean animate) {
//        ((GradientDrawable)mCircle.getDrawable()).setColor(mFadeCircleColor);
//        mCircle.setColorFilter(mFadeCircleColor);
        mCircle.setColorFilter(ActivityCompat.getColor(getContext(), R.color.grey));
        mName.setAlpha(mFadeTextAlpha);
    }
}
