package cuishihao.bawie.com.demo02.view;



import java.util.List;

import cuishihao.bawie.com.demo02.model.GoosListBean;

/**
 * 商品列表的View接口
 */

public interface IGoodsListView {
    //展示商品列表的方法
    void showGoodsList(List<GoosListBean.DataBean> data);
}
