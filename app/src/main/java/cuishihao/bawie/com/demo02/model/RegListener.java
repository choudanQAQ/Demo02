package cuishihao.bawie.com.demo02.model;

/**
 * 注册的回调接口
 */

public interface RegListener {
    void regSuccess(String json);

    void regError(String error);
}
