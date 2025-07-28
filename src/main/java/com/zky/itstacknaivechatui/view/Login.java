package com.zky.itstacknaivechatui.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: ZhangKaiYuan
 * @description:
 * @create: 2025/7/28
 */
public class Login extends Stage {
    private static final String RESOURCE_NAME = "/com/zky/itstacknaivechatui/login/login.fxml";

    private Parent root;

    /**
     * 构造函数，初始化登录窗口
     * 1. 加载FXML布局文件
     * 2. 创建透明场景
     * 3. 设置窗口样式和属性
     */
    public Login() {
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

        // 创建场景并设置透明背景
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        // 将场景设置到当前Stage
        setScene(scene);

        // 设置窗口为无边框透明样式
        initStyle(StageStyle.TRANSPARENT);

        // 禁止窗口调整大小
        setResizable(false);

        // 设置窗口图标(使用资源流代替URL路径)
        //this.getIcons().add(new Image("/fxml/login/img/system/logo.png"));

        InputStream iconStream = getClass().getResourceAsStream("/com/zky/itstacknaivechatui/login/img/system/logo.png");
        if (iconStream != null) {
            this.getIcons().add(new Image(iconStream));
        } else {
            System.err.println("错误：无法加载图标资源流");
        }
    }

    public <T> T $(String id, Class<T> clazz) {
        return (T) root.lookup("#" + id);
    }

    private double xOffset;
    private double yOffset;

    /**
     * 设置鼠标移动事件
     */
    private void move() {
        // 鼠标按下事件
        root.setOnMousePressed(event -> {
            xOffset = getX() - event.getSceneX();
            yOffset = getY() - event.getSceneY();
            root.setCursor(Cursor.CLOSED_HAND);
        });
        // 鼠标拖到事件
        root.setOnMouseDragged(event -> {
            setX(event.getSceneX() + xOffset);
            setY(event.getSceneY() + yOffset);
        });
        // 鼠标释放事件
        root.setOnMouseReleased(event -> {
            root.setCursor(Cursor.DEFAULT);
        });
    }

    /**
     * 最小化事件
     */
    private void min() {
        Button login_min = $("login_min", Button.class);
        login_min.setOnAction(event -> {
            System.out.println("最小化窗体");
            setIconified(true);
        });
    }

    /**
     * 退出窗体事件
     */
    private void quit() {
        Button login_close = $("login_close", Button.class);
        login_close.setOnAction(event -> {
            System.out.println("退出窗体");
            close();
            System.exit(0);
        });
    }

    /**
     * 登录操作事件
     */
    private void login() {
        TextField userId = $("userId", TextField.class);
        PasswordField userPassword = $("userPassword", PasswordField.class);
        $("login_button", Button.class).setOnAction(event -> {
            System.out.println("登录操作");
            System.out.println("用户ID: " + userId.getText());
            System.out.println("用户密码: " + userPassword.getText());
        });

    }
}
