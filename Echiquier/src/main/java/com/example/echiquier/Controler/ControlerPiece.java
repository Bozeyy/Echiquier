package com.example.echiquier.Controler;

import com.example.echiquier.Modele.Piece;
import com.example.echiquier.Vue.VueEchiquier;
import com.example.echiquier.util.util;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class ControlerPiece implements EventHandler {

    public Piece piece;
    public VueEchiquier vueEchiquier;

    public ControlerPiece(Piece piece, VueEchiquier vueEchiquier){
        this.piece = piece;
        this.vueEchiquier = vueEchiquier;
    }

    @Override
    public void handle(Event event) {
        System.out.println("click sur la piece");
        if (this.vueEchiquier.echiquier.tourBlanc == this.piece.blanc) {
            this.vueEchiquier.afficher();
            this.vueEchiquier.echiquier.pieceSelectionne = this.piece;
            ArrayList<int[]> coupPossible = this.piece.coupPossible(this.vueEchiquier.echiquier);
            for (int[] coup : coupPossible) {
                Rectangle rectangle = new Rectangle(util.SIZE, util.SIZE, Color.GREEN);
                rectangle.setTranslateX(coup[0] * util.SIZE);
                rectangle.setTranslateY(coup[1] * util.SIZE);
                this.vueEchiquier.getChildren().add(rectangle);
                rectangle.setOnMouseClicked(e -> {
                    this.vueEchiquier.echiquier.deplacerPiece(this.piece, coup[0], coup[1]);
                    this.vueEchiquier.afficher();
                });
            }
        }
        else {
            System.out.println("ce n'est pas votre tour");
        }
    }
}
