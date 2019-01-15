package com.mvp.samplekotlin.view.activity

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.Theme
import com.mvp.samplekotlin.R
import com.mvp.samplekotlin.core.base.BaseCoreActivity
import com.mvp.samplekotlin.data.cloud.exception.CloudException
import com.mvp.samplekotlin.mvp.presenter.LoginPresenterImpl
import com.mvp.samplekotlin.mvp.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar_home_header.*
import javax.inject.Inject

class LoginActivity : BaseCoreActivity(), LoginView {
    @Inject
    lateinit var presenterLogin: LoginPresenterImpl

    override fun setLayoutResource(): Int {
        return R.layout.activity_login
    }

    override fun setValues() {
        injectDependencyInjector()
        initializePresenter()
        email?.setText("vip5@yopmail.com")
        password?.setText("Admin123")
    }

    override fun registerClickListener(): Array<View>? {
        return arrayOf<View>(login)
    }

    override fun setToolbarId(): View? {
        return toolbar
    }

    override fun loginOnSuccess() {
        val homeIntent = Intent(this, HomeActivity::class.java)
        startActivity(homeIntent)
    }

    override fun loginOnError(e: CloudException) {
        showError(e)
    }

    override fun forgotOnSuccess() {

    }

    override fun forgotOnError(error: CloudException) {

    }

    override fun showLoadingIndicator() {
        progress_circular?.visibility = View.VISIBLE
    }

    override fun hideLoadingIndicator() {
        progress_circular?.visibility = View.GONE
    }

    override fun showError(e: Throwable) {
        val mErrorMsg = e?.message ?: "SomeThing went Wrong!"
        MaterialDialog.Builder(this)
                .title(R.string.oops)
                .content(mErrorMsg)
                .positiveText(R.string.ok)
                .theme(Theme.LIGHT)
                .show()
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.login -> {
                presenterLogin?.doLogin("vip5@yopmail.com", "Admin123")
            }
        }
    }

    override fun onDestroy() {
        presenterLogin?.destroy()
        super.onDestroy()
    }

    /**
     * initialize presenter
     */
    private fun initializePresenter() {
        presenterLogin?.setView(this);
    }

    /**
     * inject presenter
     */
    private fun injectDependencyInjector() {
        getPresenterComponent().inject(this);
    }

}