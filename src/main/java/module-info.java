module com.zky.itstacknaivechatui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.zky.itstacknaivechatui.login to javafx.fxml;
    opens com.zky.itstacknaivechatui.login.img.system to javafx.graphics;

    exports com.zky.itstacknaivechatui;
}