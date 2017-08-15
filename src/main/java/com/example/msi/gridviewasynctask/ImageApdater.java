package com.example.msi.gridviewasynctask;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by MSI on 8/15/2017.
 */

public class ImageApdater extends BaseAdapter {
    Context mContext;
    ImageView imageView;
    ArrayList<String> link;

    public ImageApdater(Context mContext,ArrayList<String> link) {
        this.mContext = mContext;
        this.link = link;
    }

    @Override
    public int getCount() {
        return link.size();
    }

    @Override
    public Object getItem(int position) {
        return link.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
        View gridView;
        if (convertView==null){
            //get layout from activitymain.xml
            convertView = inflater.inflate(R.layout.grid_view_items,null);

            imageView = (ImageView) convertView.findViewById(R.id.grid_view_img_item);

            new ShowImageTask(imageView).execute(link.get(position));

            convertView.setTag(imageView );

        }else {
            imageView = (ImageView) convertView.getTag();
        }

        return convertView;
    }
}
