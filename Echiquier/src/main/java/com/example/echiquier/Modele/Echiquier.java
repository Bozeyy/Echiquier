package com.example.echiquier.Modele;

public class Echiquier {
    public Piece[][] plateau = new Piece[8][8];

    public Echiquier() {
        for(int i =0; i<8; i++) {
            this.ajouterPiece(new Pion(i, 1, true));
            this.ajouterPiece(new Pion(i, 6, false));
        }
        this.ajouterPiece(new Tour(0, 0, true));
        this.ajouterPiece(new Tour(7, 0, true));
        this.ajouterPiece(new Tour(0, 7, false));
        this.ajouterPiece(new Tour(7, 7, false));

        this.ajouterPiece(new Cavalier(1, 0, true));
        this.ajouterPiece(new Cavalier(6, 0, true));
        this.ajouterPiece(new Cavalier(1, 7, false));
        this.ajouterPiece(new Cavalier(6, 7, false));

        this.ajouterPiece(new Fou(2, 0, true));
        this.ajouterPiece(new Fou(5, 0, true));
        this.ajouterPiece(new Fou(2, 7, false));
        this.ajouterPiece(new Fou(5, 7, false));

        this.ajouterPiece(new Reine(3, 0, true));
        this.ajouterPiece(new Reine(3, 7, false));

        this.ajouterPiece(new Roi(4, 0, true));
        this.ajouterPiece(new Roi(4, 7, false));
    }


    /**
     * méthode ajouterPiece
     * @param piece
     */
    public void ajouterPiece(Piece piece) {
        plateau[piece.x][piece.y] = piece;
    }
}
