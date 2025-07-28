package com.zky.itstacknaivechatui;

import com.zky.itstacknaivechatui.view.Login;
import javafx.stage.Stage;

/**
 * @author: ZhangKaiYuan
 * @description:
 * @create: 2025/7/28
 */
public class Application extends javafx.application.Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Login login = new Login();
        login.show();
    }

    public static void main(String[] args) {
        //启动JavaFX应用程序
        launch(args);
    }
}
