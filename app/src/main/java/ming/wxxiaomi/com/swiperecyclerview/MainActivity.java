package ming.wxxiaomi.com.swiperecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ming.wxxiaomi.com.swiperecyclerview.activity.ErrorActivity;
import ming.wxxiaomi.com.swiperecyclerview.activity.NoDataActivity;
import ming.wxxiaomi.com.swiperecyclerview.activity.NormalActivity;
import ming.wxxiaomi.com.swiperecyclerview.pulltorefresh.recycleview.PullToRefreshRecyclerView;

/**
 *  需求：
 *  当进入activity的时候自动加载数据
 *  加载数据的时候也需要展示
 *  需要显示搜索结果(成功展示数据，失败则提示用户)
 *  ---成功：展示数据，当数据源为0时则提示
 *  ---失败：提示失败原因：未登录，网络链接失败，服务器拒绝服务等
 *  litview在此场景下需要几种状态：
 *  1.加载中
 *  2.数据展示
 *  3.数据源为0
 *  4.加载失败：错误提示
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button normal;
    private Button nodata;
    private Button error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normal = (Button) findViewById(R.id.normal);
        normal.setOnClickListener(this);
        nodata = (Button) findViewById(R.id.nodata);
        nodata.setOnClickListener(this);
        error = (Button) findViewById(R.id.error);
        error.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.normal:
                intent = new Intent(this, NormalActivity.class);
                break;
            case R.id.nodata:
                intent = new Intent(this, NoDataActivity.class);
                break;
            case R.id.error:
                intent = new Intent(this, ErrorActivity.class);
                break;
        }
        startActivity(intent);
    }
}
