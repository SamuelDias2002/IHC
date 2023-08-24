module com.example.desenho {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.desenho to javafx.fxml;
    exports com.example.desenho;
}