package ming.wxxiaomi.com.swiperecyclerview.pulltorefresh.baseadapter.interfaces;


import ming.wxxiaomi.com.swiperecyclerview.pulltorefresh.baseadapter.ViewHolder;

/**
 * Author: Othershe
 * Time: 2016/8/29 10:48
 */
public interface OnSwipeMenuClickListener<T> {
    void onSwipMenuClick(ViewHolder viewHolder, T data, int position);
}
