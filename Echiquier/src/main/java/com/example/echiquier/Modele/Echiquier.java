package com.example.echiquier.Modele;

public class Echiquier {
    public Piece[][] plateau = new Piece[8][8];
    public Piece pieceSelectionne = null;
    public boolean tourBlanc = true;
    public Roi roiBlanc = null;
    public Roi roiNoir = null;

    public Echiquier() {
        for (int i = 0; i < 8; i++) {
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

        this.roiBlanc = new Roi(4, 0, true);
        this.roiNoir = new Roi(4, 7, false);
        this.ajouterPiece(this.roiBlanc);
        this.ajouterPiece(this.roiNoir);
    }


    /**
     * méthode ajouterPiece
     *
     * @param piece
     */
    public void ajouterPiece(Piece piece) {
        plateau[piece.x][piece.y] = piece;
    }

    /**
     * méthode deplacerPiece
     *
     * @param piece
     * @param x
     * @param y
     */
    public void deplacerPiece(Piece piece, int x, int y) {
        int xDepart = piece.x;
        int yDepart = piece.y;
        Piece pieceArrive = plateau[x][y];
        piece.x = x;
        piece.y = y;
        plateau[xDepart][yDepart] = null;
        plateau[x][y] = piece;
        if (this.tourBlanc) {
            if (this.isRoiEnEchec(this.roiBlanc)) {
                piece.x = xDepart;
                piece.y = yDepart;
                plateau[xDepart][yDepart] = piece;
                plateau[x][y] = pieceArrive;
                System.out.println("Déplacement impossible");
            } else {
                this.tourBlanc = false;
            }
        } else {
            if (this.isRoiEnEchec(this.roiNoir)) {
                piece.x = xDepart;
                piece.y = yDepart;
                plateau[xDepart][yDepart] = piece;
                plateau[x][y] = pieceArrive;
                System.out.println("Déplacement impossible");
            } else {
                this.tourBlanc = true;
            }
        }
    }

    /**
     * méthode isRoiEnEchec
     *
     * @param roi
     */
    public boolean isRoiEnEchec(Roi roi) {
        System.out.println("isRoiEnEchec");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.plateau[i][j] != null) {
                    if (this.plateau[i][j].blanc != roi.blanc) {
                        if (this.plateau[i][j].coupPossible(this).contains(new int[]{roi.x, roi.y})) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
