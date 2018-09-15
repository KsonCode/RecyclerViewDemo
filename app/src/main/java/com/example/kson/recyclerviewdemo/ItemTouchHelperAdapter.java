package com.example.kson.recyclerviewdemo;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/15
 * Description:
 */
public interface ItemTouchHelperAdapter {
    //数据交换
    void onItemMove(int fromPosition,int toPosition);
    //数据删除
    void onItemDissmiss(int position);
}
