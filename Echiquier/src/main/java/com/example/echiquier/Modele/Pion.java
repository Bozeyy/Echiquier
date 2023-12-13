package com.example.echiquier.Modele;

import java.util.ArrayList;

public class Pion extends Piece {

    public Pion(int x, int y, boolean blanc) {
        super(x, y, blanc);
    }

    public int getMaxPiece() {
        return 8;
    }

    @Override
    public ArrayList<int[]> coupPossible(Echiquier echiquier) {
        ArrayList<int[]> coupPossible = new ArrayList<int[]>();

        int x = this.x;
        int y = this.y;
        if (this.blanc) {
            x = this.x - 1;
            if (x >= 0) {
                if (echiquier.plateau[x][y] == null) {
                    coupPossible.add(new int[]{x, y});
                }
            }
            x = this.x - 1;
            y = this.y - 1;
            if (x >= 0 && y >= 0) {
                if (echiquier.plateau[x][y] != null) {
                    if (echiquier.plateau[x][y].blanc != this.blanc) {
                        coupPossible.add(new int[]{x, y});
                    }
                }
            }
            x = this.x - 1;
            y = this.y + 1;
            if (x >= 0 && y <= 7) {
                if (echiquier.plateau[x][y] != null) {
                    if (echiquier.plateau[x][y].blanc != this.blanc) {
                        coupPossible.add(new int[]{x, y});
                    }
                }
            }
            if (this.x == 6) {
                x = this.x - 2;
                if (x >= 0) {
                    if (echiquier.plateau[x][y] == null) {
                        coupPossible.add(new int[]{x, y});
                    }
                }
            }

        } else {
            x = this.x + 1;
            if (x <= 7) {
                if (echiquier.plateau[x][y] == null) {
                    coupPossible.add(new int[]{x, y});
                }
            }
            x = this.x + 1;
            y = this.y - 1;
            if (x <= 7 && y >= 0) {
                if (echiquier.plateau[x][y] != null) {
                    if (echiquier.plateau[x][y].blanc != this.blanc) {
                        coupPossible.add(new int[]{x, y});
                    }
                }
            }
            x = this.x + 1;
            y = this.y + 1;
            if (x <= 7 && y <= 7) {
                if (echiquier.plateau[x][y] != null) {
                    if (echiquier.plateau[x][y].blanc != this.blanc) {
                        coupPossible.add(new int[]{x, y});
                    }
                }
            }
            if (this.x == 1) {
                x = this.x + 2;
                if (x <= 7) {
                    if (echiquier.plateau[x][y] == null) {
                        coupPossible.add(new int[]{x, y});
                    }
                }
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
