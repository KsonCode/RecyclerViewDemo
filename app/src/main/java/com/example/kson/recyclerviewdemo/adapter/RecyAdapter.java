package com.example.kson.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kson.recyclerviewdemo.ItemTouchHelperAdapter;
import com.example.kson.recyclerviewdemo.R;
import com.example.kson.recyclerviewdemo.bean.Product;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/05/16
 * Description:
 */
public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.MyViewHOlder> implements ItemTouchHelperAdapter {

    private Context context;
    private List<Product> list;

    public RecyAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//
//    }

    @Override
    public MyViewHOlder onCreateViewHolder(ViewGroup parent, final int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        final MyViewHOlder myViewHOlder = new MyViewHOlder(view);


        return myViewHOlder;
    }

    @Override
    public void onBindViewHolder(MyViewHOlder holder, final int position) {


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int pos = myViewHOlder.getLayoutPosition();
                if (clickListener != null) {
                    clickListener.onItemClickListener(v, position);
                }
            }
        });

        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (clickListener != null) {
                    clickListener.onItemLongClickListener(v, position);
                }
                return false;
            }
        });
        Product product = list.get(position);

        holder.titleTv.setText(product.title);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
//交换位置
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDissmiss(int position) {
//移除数据
        list.remove(position);
        notifyItemRemoved(position);
    }

    static class MyViewHOlder extends RecyclerView.ViewHolder {

        private TextView titleTv;
        private View itemView;
        private LinearLayout layout;

        public MyViewHOlder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            layout = itemView.findViewById(R.id.root_layout);
            titleTv = itemView.findViewById(R.id.procuct_tv);
        }
    }

    private ClickListener clickListener;

    public interface ClickListener {
        void onItemClickListener(View view, int position);

        void onItemLongClickListener(View view, int position);
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
