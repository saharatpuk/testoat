package com.example.nsc2018.testoat.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nsc2018.testoat.model.DataItem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by NSC2018 on 12/8/2017.
 */

public class DataAdapter extends ArrayAdapter<DataItem> {
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<DataItem> mDataItemsList;

    public DataAdapter(@NonNull Context context, int layoutResId, @NonNull ArrayList<DataItem> mDataItemsList) {
        super(context, layoutResId, mDataItemsList);

        this.mContext = context;
        this.mLayoutResId = layoutResId;
        this.mDataItemsList = mDataItemsList;
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        DataItem item = mDataItemsList.get(position);

        return itemLayout;


    }

}
