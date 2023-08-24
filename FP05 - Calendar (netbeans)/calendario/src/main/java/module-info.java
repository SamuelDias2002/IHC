module com.example.calendario {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calendario to javafx.fxml;
    exports com.example.calendario;
}