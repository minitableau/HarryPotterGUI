module com.example.harrypottergui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.harrypottergui to javafx.fxml;
    exports com.example.harrypottergui;
    exports com.example.harrypottergui.vue;
    opens com.example.harrypottergui.vue to javafx.fxml;
}