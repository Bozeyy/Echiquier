package com.example.echiquier.Vue;

import com.example.echiquier.Modele.Echiquier;
import com.example.echiquier.Modele.Piece;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VueEchiquier extends Pane {
    public Echiquier echiquier;

    public VueEchiquier(Echiquier echiquier) {
        this.echiquier = echiquier;
    }

    public void afficher() {
        this.getChildren().clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println("i = " + i + " j = " + j);
                //   on fait des carrés blancs et noirs de 100 pixels de côté
                Rectangle rectangle = new Rectangle(100, 100, (i + j) % 2 == 0 ? javafx.scene.paint.Color.WHITE : Color.CORAL);
                rectangle.setX(i * 100);
                rectangle.setY(j * 100);
                this.getChildren().add(rectangle);
                if (echiquier.plateau[i][j] != null) {
                    String pathImage = echiquier.plateau[i][j].getPathImage();
                    System.out.printf("pathImage = %s\n", pathImage);
                    if (pathImage != null) {
                        Image image = new Image(pathImage);
                        javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(image);
                        imageView.setX(i * 100);
                        imageView.setY(j * 100);
                        this.getChildren().add(imageView);
                    }
                }
            }
        }
    }
}
