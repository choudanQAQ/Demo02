package cuishihao.bawie.com.demo02.presenter;


import cuishihao.bawie.com.demo02.model.IModel;
import cuishihao.bawie.com.demo02.view.IGoodsListView;
import cuishihao.bawie.com.demo02.view.IMainView;
import cuishihao.bawie.com.demo02.view.IRegView;

/**
 * Created by gjl on 2018/4/20.
 */

public interface Ipresenter {
    //    登录
    void loginPresenter(IModel iModel, IMainView iMainView);

    //    注册
    void regPresenter(IModel iModel, IRegView iRegView);
    //   显示数据
    void showGoodsListToView(IModel iModel, IGoodsListView iGoodsListView);
}
