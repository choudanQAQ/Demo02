package cuishihao.bawie.com.demo02.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.List;

import cuishihao.bawie.com.demo02.R;
import cuishihao.bawie.com.demo02.model.GoosListBean;
import cuishihao.bawie.com.demo02.model.ModelImpl;
import cuishihao.bawie.com.demo02.model.MyAdater;
import cuishihao.bawie.com.demo02.model.MyAdater2;
import cuishihao.bawie.com.demo02.presenter.Presenter;

/**
 * 商品列表页
 */

public class GoodsListActivity extends Activity implements View.OnClickListener, IGoodsListView {

    private ListView listView;
    private GridView gridView;
    private static final String TAG = "GoodsListActivity---";
    private boolean flag = true;
    private ImageView change;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_list_layout);
        //初始化界面
        initViews();
        //请求书
        Presenter presenter = new Presenter();
        presenter.showGoodsListToView(new ModelImpl(), this);
    }

    private void initViews() {
        change = findViewById(R.id.goodslist_change);
        change.setOnClickListener(this);
        listView = findViewById(R.id.goodslist_listview);
        gridView = findViewById(R.id.goodslist_gridview);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goodslist_change:
                if (flag) {

                    gridView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                } else {

                    gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                }
                flag = !flag;
                break;
        }
    }

    //展示商品列表的方法
    @Override
    public void showGoodsList(List<GoosListBean.DataBean> data) {
        Log.d(TAG, "showGoodsList: " + data);
        //展示
        MyAdater myAdater = new MyAdater(GoodsListActivity.this, data);
        MyAdater2 myAdater2 = new MyAdater2(GoodsListActivity.this, data);
        listView.setAdapter(myAdater);

        gridView.setAdapter(myAdater2);
    }
}
