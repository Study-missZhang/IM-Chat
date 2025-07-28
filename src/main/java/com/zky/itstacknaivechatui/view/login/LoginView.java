package com.zky.itstacknaivechatui.view.login;

/**
 * @author: ZhangKaiYuan
 * @description: 窗体展示
 * @create: 2025/7/28
 */
public class LoginView {

    private LoginInit loginInit;
    private ILoginEvent loginEvent;

    public LoginView(LoginInit loginInit, ILoginEvent loginEvent) {
        this.loginInit = loginInit;
        this.loginEvent = loginEvent;
    }
}
