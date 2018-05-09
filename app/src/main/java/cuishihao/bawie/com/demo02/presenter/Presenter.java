package cuishihao.bawie.com.demo02.presenter;

import android.util.Log;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import cuishihao.bawie.com.demo02.http.HttpConfig;
import cuishihao.bawie.com.demo02.model.GoodsListListener;
import cuishihao.bawie.com.demo02.model.GoosListBean;
import cuishihao.bawie.com.demo02.model.IModel;
import cuishihao.bawie.com.demo02.model.LoginListener;
import cuishihao.bawie.com.demo02.model.RegListener;
import cuishihao.bawie.com.demo02.view.IGoodsListView;
import cuishihao.bawie.com.demo02.view.IMainView;
import cuishihao.bawie.com.demo02.view.IRegView;

/**
 * Created by gjl on 2018/4/20.
 */

public class Presenter implements Ipresenter {
    private static final String TAG = "Presenter-----";
    //登录
    @Override
    public void loginPresenter(IModel iModel, final IMainView iMainView) {
        //调用m请求数据
        Map<String, String> map = new HashMap<>();
        map.put("mobile", iMainView.getMobile());
        map.put("password", iMainView.getPassword());
        iModel.login(HttpConfig.login_url, map, new LoginListener() {
            //根据回调结果，决定view的显示效果
            @Override
            public void loginSuccess(String json) {
                iMainView.loginSuccess();
            }

            @Override
            public void loginError(String error) {
                iMainView.loginError();
            }
        });

    }

    //注册
    @Override
    public void regPresenter(IModel iModel, final IRegView iRegView) {
        //调用m请求数据
        Map<String, String> map = new HashMap<>();
        map.put("mobile", iRegView.getMobile());
        map.put("password", iRegView.getPassword());
        iModel.reg(HttpConfig.reg_url, map, new RegListener() {
            @Override
            public void regSuccess(String json) {
                iRegView.regSuccess();
            }

            @Override
            public void regError(String error) {
                iRegView.regError();
            }
        });
    }
    //   显示数据
    @Override
    public void showGoodsListToView(IModel iModel, final IGoodsListView iGoodsListView) {
        Map<String, String> map = new HashMap<>();
        map.put("keywords", "笔记本");
        map.put("page", "1");
        iModel.getGoodsListData(HttpConfig.goods_list_url, map, new GoodsListListener() {

            @Override
            public void getDataSuccess(String json) {
                Gson gson = new Gson();
                GoosListBean goosListBean = gson.fromJson(json, GoosListBean.class);
                iGoodsListView.showGoodsList(goosListBean.getData());
            }

            @Override
            public void getDataError(String error) {
                Log.d(TAG, "失败---");
            }
        });
    }
}
