package cuishihao.bawie.com.demo02.model;

/**
 * 注册的回调接口
 */

public interface GoodsListListener {
    //    获取数据成功
    void getDataSuccess(String json);

    //获取数据失败
    void getDataError(String error);
}
