package com.zky.itstacknaivechatui.view.login;

import com.zky.itstacknaivechatui.view.UIObject;

/**
 * @author: ZhangKaiYuan
 * @description: 窗体控制管理类，也是一个窗体的管家；继承窗体的载体、实现接口方法、初始化界面、初始化事件定义
 * @create: 2025/7/28
 */
public class LoginController extends LoginInit implements ILoginMethod{

    private LoginView loginView;
    private LoginEventDefine loginEventDefine;

    public LoginController(ILoginEvent loginEvent){
        super(loginEvent);
    }

    @Override
    public void initView() {
        loginView = new LoginView(this, loginEvent);
    }

    @Override
    public void initEventDefine() {
        loginEventDefine = new LoginEventDefine(this, loginEvent, this);
    }


    @Override
    public void doShow() {
        super.show();
    }

    @Override
    public void doLoginError() {
        System.out.println("登陆失败，执行提示操作");
    }

    @Override
    public void doLoginSuccess() {
        System.out.println("登陆成功，执行跳转操作");
        // 关闭原窗口
        close();
    }


}
