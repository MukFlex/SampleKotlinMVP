package com.mvp.samplekotlin.mvp.presenter;


import com.mvp.samplekotlin.data.model.login.Login;
import com.mvp.samplekotlin.mvp.view.LoginView;



public interface LoginPresenter extends Presenter<LoginView> {

    void doLogin(String email, String password);
    void doForgotPassword(String email);
    void saveLoginAccess(Login login);
}
