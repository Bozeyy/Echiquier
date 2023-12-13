package com.example.echiquier;

import com.example.echiquier.Modele.Echiquier;
import com.example.echiquier.Vue.VueEchiquier;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Echiquier echiquier = new Echiquier();
        VueEchiquier vueEchiquier = new VueEchiquier(echiquier);
        Scene scene = new Scene(vueEchiquier, 800, 800);
        vueEchiquier.afficher();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}