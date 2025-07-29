package com.zky.itstacknaivechatui.view.chat;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.InputStream;
import java.net.URL;

/**
 * @author: ZhangKaiYuan
 * @description:
 * @create: 2025/7/29
 */
public class ChatEventDefine {

    private ChatInit chatInit;

    public ChatEventDefine(ChatInit chatInit) {
        this.chatInit = chatInit;

        chatInit.move();
        this.barChat();
        this.barFriend();
    }

    /**
     * 切换聊天按钮状态和显示/隐藏群聊
     * @param bar_chat 聊天按钮
     * @param group_bar_chat 群聊按钮
     * @param toggle true 切换为群聊 false 切换为单聊
     */
    private void switchBarChat(Button bar_chat, Pane group_bar_chat, boolean toggle) {
        if (toggle){
            // 设置聊天按钮为激活状态
            bar_chat.setStyle("-fx-background-image: url('/com/zky/itstacknaivechatui/chat/img/system/chat_2.png')");
            group_bar_chat.setVisible(true);
        } else {
            // 设置聊天按钮为未激活状态
            bar_chat.setStyle("-fx-background-image: url('/com/zky/itstacknaivechatui/chat/img/system/chat_0.png')");
            group_bar_chat.setVisible(false);
        }
    }

    /**
     * 切换好友按钮状态和显示/隐藏群聊
     * @param bar_friend
     * @param group_bar_friend
     * @param toggle
     */
    private void switchBarFriend(Button bar_friend, Pane group_bar_friend, boolean toggle) {
        if(toggle){
            InputStream iconStream = getClass().getResourceAsStream("/com/zky/itstacknaivechatui/chat/img/system/friend_2.png");

            if(iconStream != null){
                Image image = new Image(iconStream);
                BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

                bar_friend.setBackground(new Background(backgroundImage));

                group_bar_friend.setVisible(true);
            }
            /*bar_friend.setStyle("-fx-background-image: url('/com/zky/itstacknaivechatui/chat/img/system/friend_2.png')");
            group_bar_friend.setVisible(true);*/
        } else {
            bar_friend.setStyle("-fx-background-image: url('/com/zky/itstacknaivechatui/chat/img/system/friend_0.png')");
            group_bar_friend.setVisible(false);
        }
    }

    /**
     * 初始化聊天按钮的事件处理
     * 1. 设置按钮点击事件：切换聊天状态并隐藏好友状态
     * 2. 设置鼠标悬停事件：显示悬停效果图片
     * 3. 设置鼠标移出事件：恢复默认效果图片
     */
    private void barChat() {
        Button bar_chat = chatInit.$("bar_chat", Button.class);
        Pane group_bar_chat = chatInit.$("group_bar_chat", Pane.class);
        //设置按钮点击事件
        bar_chat.setOnAction(event -> {
            switchBarChat(bar_chat, group_bar_chat, true);
            switchBarFriend(chatInit.$("bar_friend", Button.class), chatInit.$("group_bar_friend", Pane.class), false);
        });
        //设置按钮鼠标移入事件
        bar_chat.setOnMouseEntered(event -> {
            boolean visible = group_bar_chat.isVisible();
            if (visible) return;
            bar_chat.setStyle("-fx-background-image: url('/com/zky/itstacknaivechatui/chat/img/system/chat_1.png')");
        });
        //设置按钮鼠标移出事件
        bar_chat.setOnMouseExited(event -> {
            boolean visible = group_bar_chat.isVisible();
            if (visible) return;
            bar_chat.setStyle("-fx-background-image: url('/com/zky/itstacknaivechatui/chat/img/system/chat_0.png')");
        });
    }

    private void barFriend() {
        Button bar_friend = chatInit.$("bar_friend", Button.class);
        Pane group_bar_friend = chatInit.$("group_bar_friend", Pane.class);
        bar_friend.setOnAction(event -> {
            switchBarChat(chatInit.$("bar_chat", Button.class), chatInit.$("group_bar_chat", Pane.class), false);
            switchBarFriend(bar_friend, group_bar_friend, true);
        });
        bar_friend.setOnMouseEntered(event -> {
            boolean visible = group_bar_friend.isVisible();
            if (visible) return;
            bar_friend.setStyle("-fx-background-image: url('/com/zky/itstacknaivechatui/chat/img/system/friend_1.png')");
        });
        bar_friend.setOnMouseExited(event -> {
            boolean visible = group_bar_friend.isVisible();
            if (visible) return;
            bar_friend.setStyle("-fx-background-image: url('/com/zky/itstacknaivechatui/chat/img/system/friend_0.png')");
        });
    }
}
