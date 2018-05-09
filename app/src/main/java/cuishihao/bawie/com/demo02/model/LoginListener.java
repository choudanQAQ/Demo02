package cuishihao.bawie.com.demo02.model;

/**
 * Created by gjl on 2018/4/20.
 */

public interface LoginListener {
    void loginSuccess(String json);

    void loginError(String error);
}
