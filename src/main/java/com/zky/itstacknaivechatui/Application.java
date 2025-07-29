package com.zky.itstacknaivechatui;

import com.zky.itstacknaivechatui.view.UIObject;
import com.zky.itstacknaivechatui.view.chat.ChatController;
import com.zky.itstacknaivechatui.view.chat.IChatMethod;
import com.zky.itstacknaivechatui.view.login.ILoginMethod;
import com.zky.itstacknaivechatui.view.login.LoginController;
import javafx.stage.Stage;

/**
 * @author: ZhangKaiYuan
 * @description:
 * @create: 2025/7/28
 */
public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        IChatMethod chatMethod = new ChatController();
        chatMethod.doShow();

        /*ILoginMethod login = new LoginController((userId, userPassword) -> {
            System.out.println("登录 userId: " + userId + "userPassword: " + userPassword);
        });

        login.doShow();*/
    }

    public static void main(String[] args) {
        //启动JavaFX应用程序
        launch(args);
    }
}
