package com.example.kson.recyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kson.recyclerviewdemo.R;

import java.util.List;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/05/16
 * Description:
 */
public class RecyclerViewAdapter extends BaseAdapter {


    private String str;
    private Context mContext;

    public RecyclerViewAdapter(String str, Context context, List<String> data) {
        this.str = str;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHodler viewHodler = null;
        if (convertView==null){
            viewHodler = new ViewHodler();
            convertView = View.inflate(mContext, R.layout.activity_main,null);
            viewHodler.tv = convertView.findViewById(R.id.always);
            convertView.setTag(viewHodler);
        }else{
            viewHodler = (ViewHodler) convertView.getTag();
        }

        viewHodler.tv.setText("str");

        return convertView;
    }

    static  class ViewHodler{

        private TextView tv;

    }
}
