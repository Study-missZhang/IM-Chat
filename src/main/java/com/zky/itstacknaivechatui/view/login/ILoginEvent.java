package com.zky.itstacknaivechatui.view.login;

/**
 * @author: ZhangKaiYuan
 * @description: 事件接口类，具体实现交给调用方。
 * @create: 2025/7/28
 */
public interface ILoginEvent {

    /**
     * 登录验证
     * @param userId        用户ID
     * @param userPassword  用户密码
     */
    void doLoginCheck(String userId, String userPassword);
}
