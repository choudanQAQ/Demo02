package cuishihao.bawie.com.demo02.model;

import android.util.Log;


import com.google.gson.Gson;

import java.util.Map;

import cuishihao.bawie.com.demo02.http.HttpUtils;
import cuishihao.bawie.com.demo02.http.OkLoadListener;

/**
 * Created by gjl on 2018/4/20.
 */

public class ModelImpl implements IModel {

    private static final String TAG = "ModelImpl----";

    @Override
    public void login(final String url, Map<String, String> params, final LoginListener loginListener) {
        //
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        //调用post请求
        httpUtils.okPost(url, params);
        //        设置回调监听
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {

                Log.d(TAG, "okLoadSuccess: " + json);

                //将数据传入p层
                //解析json  如果code是0，成功，否则失败
                Gson gson = new Gson();
                UserBean userBean = gson.fromJson(json, UserBean.class);
                if (userBean.getCode().equals("0")) {
                    loginListener.loginSuccess(json);
                } else {
                    loginListener.loginError(json);
                }

            }

            @Override
            public void okLoadError(String error) {
                loginListener.loginError(error);
            }
        });
    }

    //注册
    @Override
    public void reg(String url, Map<String, String> params, final RegListener regListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.okPost(url, params);//调用post请求
//        设置回调监听
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {

                Log.d(TAG, "okLoadSuccess: " + json);

                //将数据传入p层
                //解析json  如果code是0，成功，否则失败
                Gson gson = new Gson();
                RegBean userBean = gson.fromJson(json, RegBean.class);
                if (userBean.getCode().equals("0")) {
                    regListener.regSuccess(json);
                } else {
                    regListener.regError(json);
                }

            }

            @Override
            public void okLoadError(String error) {
                regListener.regError(error);
            }
        });
    }
    //    获取商品数据
    @Override
    public void getGoodsListData(String url, Map<String, String> params, final GoodsListListener goodsListListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils();
        httpUtils.okPost(url, params);//调用post请求
//        设置回调监听
        httpUtils.setOkLoadListener(new OkLoadListener() {
            @Override
            public void okLoadSuccess(String json) {

                Log.d(TAG, "okLoadSuccess: " + json);

                //将数据传入p层
                //解析json  如果code是0，成功，否则失败
                Gson gson = new Gson();
                GoosListBean goosListBean = gson.fromJson(json, GoosListBean.class);
                if (goosListBean.getCode().equals("0")) {
                    goodsListListener.getDataSuccess(json);
                } else {
                    goodsListListener.getDataError(json);
                }
            }

            @Override
            public void okLoadError(String error) {
                goodsListListener.getDataError(error);
            }
        });
    }
}
