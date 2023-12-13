module com.example.echiquier {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.echiquier to javafx.fxml;
    exports com.example.echiquier;
}