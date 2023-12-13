package com.example.echiquier.Modele;

import java.util.ArrayList;

public class Cavalier extends Piece {

    public Cavalier(int x, int y, boolean blanc) {
        super(x, y, blanc);
    }

    @Override
    public int getMaxPiece() {
        return 0;
    }

    @Override
    public ArrayList<int[]> coupPossible(Echiquier echiquier) {
        ArrayList<int[]> coupPossible = new ArrayList<int[]>();

        int x = this.x + 1;
        int y = this.y + 2;
        if(x <= 7 && y <= 7){
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
            }
        }

        x = this.x + 1;
        y = this.y - 2;
        if(x <= 7 && y >= 0){
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
            }
        }

        x = this.x - 1;
        y = this.y + 2;
        if(x >= 0 && y <= 7){
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
            }
        }

        x = this.x - 1;
        y = this.y - 2;
        if(x >= 0 && y >= 0){
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
            }
        }

        x = this.x + 2;
        y = this.y + 1;
        if(x <= 7 && y <= 7){
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
            }
        }

        x = this.x + 2;
        y = this.y - 1;
        if(x <= 7 && y >= 0){
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
            }
        }

        x = this.x - 2;
        y = this.y + 1;
        if(x >= 0 && y <= 7){
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
            }
        }

        x = this.x - 2;
        y = this.y - 1;
        if(x >= 0 && y >= 0){
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
            }
        }
        return coupPossible;
    }

    @Override
    public String getPathImage() {
        if (this.blanc) {
            return "src/main/resources/CavalierBlanc.png";
        } else {
            return "src/main/resources/CavalierNoir.png";
        }
    }

}
