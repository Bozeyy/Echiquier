package com.example.echiquier.Modele;

import java.util.ArrayList;

public abstract class Piece {
    public int x;
    public int y;
    public boolean blanc;

    public Piece(int x, int y, boolean blanc) {
        this.x = x;
        this.y = y;
        this.blanc = blanc;
    }

    public abstract int getValue();

    public abstract ArrayList<int[]> coupPossible(Echiquier echiquier);

    public abstract String getPathImage();
}
