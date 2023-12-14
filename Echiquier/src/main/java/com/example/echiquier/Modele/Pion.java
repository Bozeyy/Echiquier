package com.example.echiquier.Modele;

import java.util.ArrayList;

public class Pion extends Piece {

    public Pion(int x, int y, boolean blanc) {
        super(x, y, blanc);
    }

    public int getValue() {
        return 8;
    }

    @Override
    public ArrayList<int[]> coupPossible(Echiquier echiquier) {
        ArrayList<int[]> coupPossible = new ArrayList<>();

        int x = this.x;
        int y = this.y;

        if (this.blanc) {
            System.out.println("Pion blanc");
            // Check one step forward
            if (echiquier.plateau[x][y+1] == null && y+1 <= 7) {
                coupPossible.add(new int[]{x, y+1});
            }
            if (y == 1 && echiquier.plateau[x][y+2] == null) {
                coupPossible.add(new int[]{x, y+2});
            }

            // check diagonal captures
            if (x + 1 <= 7 && y + 1 <= 7 && echiquier.plateau[x + 1][y + 1] != null && !echiquier.plateau[x + 1][y + 1].blanc) {
                coupPossible.add(new int[]{x + 1, y + 1});
            }
            if (x - 1 >= 0 && y + 1 <= 7 && echiquier.plateau[x - 1][y + 1] != null && !echiquier.plateau[x - 1][y + 1].blanc) {
                coupPossible.add(new int[]{x - 1, y + 1});
            }

        } else {
            System.out.println("Pion noir");
            // Check one step forward
            if (echiquier.plateau[x][y-1] == null && y-1 >= 0) {
                coupPossible.add(new int[]{x, y-1});
            }
            if (y == 6 && echiquier.plateau[x][y-2] == null) {
                coupPossible.add(new int[]{x, y-2});
            }

            // check diagonal captures
            if (x + 1 <= 7 && y - 1 >= 0 && echiquier.plateau[x + 1][y - 1] != null && echiquier.plateau[x + 1][y - 1].blanc) {
                coupPossible.add(new int[]{x + 1, y - 1});
            }
            if (x - 1 >= 0 && y - 1 >= 0 && echiquier.plateau[x - 1][y - 1] != null && echiquier.plateau[x - 1][y - 1].blanc) {
                coupPossible.add(new int[]{x - 1, y - 1});
            }
        }
        return coupPossible;
    }


    @Override
    public String getPathImage() {
        if (this.blanc) {
            return "src/main/resources/PionBlanc.png";
        } else {
            return "src/main/resources/PionNoir.png";
        }
    }

}
