package com.example.echiquier.Vue;

import com.example.echiquier.Controler.ControlerPiece;
import com.example.echiquier.Modele.Echiquier;
import com.example.echiquier.Modele.Piece;
import com.example.echiquier.util.util;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;

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
                Rectangle rectangle = new Rectangle(util.SIZE, util.SIZE, (i + j) % 2 == 0 ? javafx.scene.paint.Color.WHITE : Color.CORAL);
                rectangle.setX(i * util.SIZE);
                rectangle.setY(j * util.SIZE);
                this.getChildren().add(rectangle);
                if (echiquier.plateau[i][j] != null) {
                    String pathImage = echiquier.plateau[i][j].getPathImage();
                    System.out.printf("pathImage = %s\n", pathImage);
                    if (pathImage != null ) {
                        Image imageViewImage = new Image(new File(pathImage).toURI().toString());
                        ImageView imageView = new ImageView(imageViewImage);
                        imageView.setX(i * util.SIZE);
                        imageView.setY(j * util.SIZE);
                        imageView.setFitHeight(util.SIZE);
                        imageView.setFitWidth(util.SIZE);
                        System.out.println("imageView = " + imageView);
                        this.getChildren().add(imageView);
                        // on set on click
                        imageView.setOnMouseClicked(new ControlerPiece(echiquier.plateau[i][j], this));
                    }
                }
            }
        }
    }
}
