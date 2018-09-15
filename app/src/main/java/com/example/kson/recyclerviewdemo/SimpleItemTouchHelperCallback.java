package com.example.kson.recyclerviewdemo;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.kson.recyclerviewdemo.adapter.RecyAdapter;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/15
 * Description:
 */
public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback{
    private RecyAdapter recyAdapter;

    public SimpleItemTouchHelperCallback(RecyAdapter recyAdapter) {
        this.recyAdapter = recyAdapter;
    }

    /**
     * 该方法用于返回可以滑动的方向，比如说允许从右到左侧滑，允许上下拖动等。我们一般使用makeMovementFlags(int,int)或makeFlag(int, int)来构造我们的返回值。
     例如：要使RecyclerView的Item可以上下拖动，同时允许从右到左侧滑，但不许允许从左到右的侧滑，我们可以这样写：
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    /**
     * 当用户拖动一个Item进行上下移动从旧的位置到新的位置的时候会调用该方法，在该方法内，我们可以调用Adapter的notifyItemMoved方法来交换两个ViewHolder的位置，最后返回true，表示被拖动的ViewHolder已经移动到了目的位置。所以，如果要实现拖动交换位置，可以重写该方法（前提是支持上下拖动）：
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        recyAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    /**
     * 当用户左右滑动Item达到删除条件时，会调用该方法，一般手指触摸滑动的距离达到RecyclerView宽度的一半时，再松开手指，此时该Item会继续向原先滑动方向滑过去并且调用onSwiped方法进行删除，否则会反向滑回原来的位置。在该方法内部我们可以这样写：
     * 如果在onSwiped方法内我们没有进行任何操作，即不删除已经滑过去的Item，那么就会留下空白的地方，因为实际上该ItemView还占据着该位置，只是移出了我们的可视范围内罢了。
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        recyAdapter.onItemDissmiss(viewHolder.getAdapterPosition());
    }

    /**
     * 该方法返回true时，表示支持长按拖动，即长按ItemView后才可以拖动，我们遇到的场景一般也是这样的。默认是返回true。
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    /**
     * 该方法返回true时，表示如果用户触摸并左右滑动了View，那么可以执行滑动删除操作，即可以调用到onSwiped()方法。默认是返回true。
     * @return
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    /**
     * 我们可以在这个方法内实现我们自定义的交互规则或者自定义的动画效果。
     * @param c
     * @param recyclerView
     * @param viewHolder
     * @param dX
     * @param dY
     * @param actionState
     * @param isCurrentlyActive
     */
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
