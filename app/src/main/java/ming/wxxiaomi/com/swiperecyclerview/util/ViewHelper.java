package ming.wxxiaomi.com.swiperecyclerview.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ming.wxxiaomi.com.swiperecyclerview.R;

/**
 * Created by Administrator on 2017/1/13.
 */

public class ViewHelper {
    public static View makeEmptyView(Context context,ViewGroup viewGroup){
        return LayoutInflater.from(context).inflate(R.layout.view_list_empty, viewGroup, false);
    }

    public static View makeReloadView(Context context, ViewGroup viewGroup, View.OnClickListener listener){
        View view = LayoutInflater.from(context).inflate(R.layout.view_list_error, viewGroup, false);
        view.setOnClickListener(listener);
        return view;
    }

    public static View makeLoadingView(Context context,ViewGroup viewGroup){
        return LayoutInflater.from(context).inflate(R.layout.view_list_loading, viewGroup, false);
    }
}
