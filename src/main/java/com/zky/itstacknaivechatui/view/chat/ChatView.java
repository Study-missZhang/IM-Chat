package com.zky.itstacknaivechatui.view.chat;

/**
 * @author: ZhangKaiYuan
 * @description:
 * @create: 2025/7/29
 */
public class ChatView {
    private ChatInit chatInit;

    private IChatEvent chatEvent;

    public ChatView(ChatInit chatInit, IChatEvent chatEvent) {
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
    }
}
