package com.zky.itstacknaivechatui.view.chat;

/**
 * @author: ZhangKaiYuan
 * @description:
 * @create: 2025/7/29
 */
public class ChatController extends ChatInit implements IChatMethod{

    private ChatEventDefine chatEventDefine;

    @Override
    public void initView() {

    }

    @Override
    public void initEventDefine() {
        chatEventDefine = new ChatEventDefine(this);
    }

    @Override
    public void doShow() {
        super.show();
    }
}
