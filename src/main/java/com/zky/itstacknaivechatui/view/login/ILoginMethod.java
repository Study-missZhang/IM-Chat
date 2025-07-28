package com.zky.itstacknaivechatui.view.login;

/**
 * @author: ZhangKaiYuan
 * @description: 方法接口类，给外部提供接口主要用于类似登录处理完毕后，来执行相应方法进行窗体切换或者数据填充
 * @create: 2025/7/28
 */
public interface ILoginMethod {

    /**
     * 打开登录窗口
     */
    void doShow();

    /**
     * 登录失败
     */
    void doLoginError();

    /**
     * 登录成功(关闭窗口，跳转到聊天窗口)
     */
    void doLoginSuccess();
}
