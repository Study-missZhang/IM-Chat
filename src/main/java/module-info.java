module com.zky.itstacknaivechatui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zky.itstacknaivechatui to javafx.fxml;
    exports com.zky.itstacknaivechatui;
}