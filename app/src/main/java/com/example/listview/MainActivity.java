package com.example.listview;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableListView;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends WearableActivity implements WearableListView.ClickListener {

    private TextView mTextView;
    String[] elements = { "List Item 1", "List Item 2", "List Item 3", "List Item 4", "List Item 5", "List Item 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
        WearableListView listView = (WearableListView) findViewById(R.id.wearable_list);

        listView.setAdapter(new MyAdapter(MainActivity.this, elements));

        listView.setClickListener(MainActivity.this);

        setAmbientEnabled();
    }

    @Override
    public void onClick(WearableListView.ViewHolder view) {
        Integer tag = (Integer) view.itemView.getTag();
        Log.i("Clicked", Integer.toString(tag));
    }

    @Override
    public void onTopEmptyRegionClick() {

    }
}
