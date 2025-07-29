package com.zky.itstacknaivechatui.view.chat;

import com.zky.itstacknaivechatui.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author: ZhangKaiYuan
 * @description:
 * @create: 2025/7/29
 */
public abstract class ChatInit extends UIObject {

    private static final String RESOURCE_NAME = "/com/zky/itstacknaivechatui/chat/chat.fxml";

    ChatInit() {
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
        InputStream iconStream = getClass().getResourceAsStream("/com/zky/itstacknaivechatui/chat/img/head/logo.png");
        if (iconStream != null) {
            this.getIcons().add(new Image(iconStream));
        } else {
            System.err.println("错误：无法加载图标资源流");
        }
        initView();
        initEventDefine();
    }
}
