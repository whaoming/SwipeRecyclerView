package ming.wxxiaomi.com.swiperecyclerview.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ming.wxxiaomi.com.swiperecyclerview.R;
import ming.wxxiaomi.com.swiperecyclerview.pulltorefresh.baseadapter.interfaces.OnLoadMoreListener;
import ming.wxxiaomi.com.swiperecyclerview.myadapter.SearchAdapter;
import ming.wxxiaomi.com.swiperecyclerview.pulltorefresh.recycleview.PullToRefreshRecyclerView;
import ming.wxxiaomi.com.swiperecyclerview.util.ViewHelper;

public class ErrorActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private SearchView searchView;
    private PullToRefreshRecyclerView mRecyclerView;
    private View header;
    private TextView tv_search;
    private SearchAdapter mAdapter;
    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        initView();
        initData();
    }

    private void initData() {
        mAdapter = new SearchAdapter(this,null, true,mRecyclerView);
        mAdapter.setEmptyView(ViewHelper.makeEmptyView(this,(ViewGroup)mRecyclerView.getParent()));
        mAdapter.setReloadView(ViewHelper.makeReloadView(this, (ViewGroup) mRecyclerView.getParent(), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("wang","重新加载");
                mAdapter.setLoading();
                isFirst = false;
                loadData();;

            }
        }));
        mAdapter.setLoadingMoreView(ViewHelper.makeLoadingView(this,(ViewGroup)mRecyclerView.getParent()));
        mAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                Log.i("wang","滑到底部啦,isReload:"+isReload);
            }
        });
        mAdapter.onAttachedToRecyclerView(mRecyclerView.getRecyclerView());
        mRecyclerView.setAdapter(mAdapter);
        loadData();


    }

    private void loadData(){

        header.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirst) {
                    mAdapter.setLoadFail();
                }else{
                    List<String> datas = new ArrayList<String>();
                    for (int i=0;i<5;i++){
                        datas.add(String.valueOf(i));
                    }
                    mAdapter.setNewData(datas);
                }

            }
        },3000);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        searchView = (SearchView) findViewById(R.id.searchView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        searchView.setIconifiedByDefault(true);//设置展开后图标的样式,这里只有两种,一种图标在搜索框外,一种在搜索框内
        searchView.onActionViewExpanded();// 写上此句后searchView初始是可以点击输入的状态，如果不写，那么就需要点击下放大镜，才能出现输入框,也就是设置为ToolBar的ActionView，默认展开
        searchView.requestFocus();//输入焦点
        searchView.setIconified(false);//输入框内icon不显示
        header = View.inflate(this, R.layout.view_header_friend_serach, null);
        tv_search = (TextView) header.findViewById(R.id.tv_search);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                presenter.onFindClick(tv_search.getText().toString().trim());
            }
        });
        mRecyclerView = (PullToRefreshRecyclerView) findViewById(R.id.mRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                presenter.onFindClick(query);
                onSumbit(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                presenter.onTextChange(newText);
                onTextChange(newText);
                return false;
            }
        });
    }

    private void onSumbit(String query) {
    }

    private void onTextChange(String newText) {

    }
}
