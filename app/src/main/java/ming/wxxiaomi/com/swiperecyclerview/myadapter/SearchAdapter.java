package ming.wxxiaomi.com.swiperecyclerview.myadapter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;

import java.util.List;

import ming.wxxiaomi.com.swiperecyclerview.R;
import ming.wxxiaomi.com.swiperecyclerview.pulltorefresh.baseadapter.ViewHolder;
import ming.wxxiaomi.com.swiperecyclerview.pulltorefresh.baseadapter.base.CommonBaseAdapter;

/**
 * Created by Administrator on 2017/1/13.
 */

public class SearchAdapter extends CommonBaseAdapter<String> {


    public SearchAdapter(Context context, List<String> datas, boolean isOpenLoadMore, SwipeRefreshLayout swipe) {
        super(context, datas, isOpenLoadMore,swipe);
    }

    @Override
    protected void convert(ViewHolder holder, String data, int position) {
        holder.setText(R.id.tv,data);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_simple;
    }
}
