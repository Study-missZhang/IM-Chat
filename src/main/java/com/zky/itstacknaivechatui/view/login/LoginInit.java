package com.zky.itstacknaivechatui.view.login;

import com.zky.itstacknaivechatui.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author: ZhangKaiYuan
 * @description: 窗体的初始化操作
 * @create: 2025/7/28
 */
public abstract class LoginInit extends UIObject {

    private static final String RESOURCE_NAME = "/com/zky/itstacknaivechatui/login/login.fxml";

    protected ILoginEvent loginEvent;

    public Button login_min;          // 登陆窗口最小化
    public Button login_close;        // 登陆窗口退出
    public Button login_button;       // 登陆按钮
    public TextField userId;          // 用户账户窗口
    public PasswordField userPassword;// 用户密码窗口


    LoginInit(ILoginEvent loginEvent) {
        this.loginEvent = loginEvent;
        try {
            //System.out.println("尝试加载资源: " + RESOURCE_NAME);
            URL resourceUrl = getClass().getResource(RESOURCE_NAME);
            //System.out.println("资源URL: " + resourceUrl);

            if (resourceUrl == null) {
                // 尝试从类加载器获取
                resourceUrl = getClass().getClassLoader().getResource(RESOURCE_NAME.substring(1));
                //System.out.println("类加载器资源URL: " + resourceUrl);
            }


            root = FXMLLoader.load(resourceUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        InputStream iconStream = getClass().getResourceAsStream("/com/zky/itstacknaivechatui/login/img/system/logo.png");
        if (iconStream != null) {
            this.getIcons().add(new Image(iconStream));
        } else {
            System.err.println("错误：无法加载图标资源流");
        }

        obtain();
        initView();
        initEventDefine();
    }

    private void obtain() {
        login_min = $("login_min", Button.class);
        login_close = $("login_close", Button.class);
        login_button = $("login_button", Button.class);
        userId = $("userId", TextField.class);
        userPassword = $("userPassword", PasswordField.class);
    }
}
