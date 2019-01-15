//package com.mvp.samplekotlin.view.activity;
//
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.view.View;
//
//import com.mvp.samplekotlin.R;
//import com.mvp.samplekotlin.core.base.BaseCoreActivity;
//import com.mvp.samplekotlin.data.cloud.exception.CloudException;
//import com.mvp.samplekotlin.mvp.presenter.LoginPresenterImpl;
//import com.mvp.samplekotlin.mvp.view.LoginView;
//
//import org.jetbrains.annotations.NotNull;
//
//import javax.inject.Inject;
//
//public class LoginActivity extends BaseCoreActivity implements LoginView {
//
//
//    @Inject
//    LoginPresenterImpl presenterLogin;
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        injectDependencyInjector();
//        initializePresenter();
//        presenterLogin.doForgotPassword("mshuiet@gmail.com");
//    }
//
//    @Override
//    public void loginOnSuccess() {
//
//    }
//
//
//
//    @Override
//    public void loginOnError(CloudException e) {
//
//    }
//
//
//
//
//    @Override
//    public void forgotOnSuccess() {
//
//    }
//
//    @Override
//    public void forgotOnError(CloudException error) {
//
//    }
//
//    @Override
//    public void showLoadingIndicator() {
//
//    }
//
//    @Override
//    public void hideLoadingIndicator() {
//
//    }
//
//    @Override
//    public void showError(Throwable e) {
//
//    }
//
//
//    private void initializePresenter() {
//        presenterLogin.setView(this);
//    }
//
//    private void injectDependencyInjector() {
//
//        getPresenterComponent().inject(this);
//    }
//
//
//
//    @Override
//    public int setLayoutResource() {
//        return R.layout.activity_login;
//    }
//
//    @Override
//    public void setValues() {
//
//    }
//
//
//
//    @Override
//    public View[] registerClickListener() {
//        return null;
//    }
//
//    @Override
//    public View setToolbarId() {
//        return null;
//    }
//
//    @Override
//    public void showToast(@NotNull String msg) {
//
//    }
//}
