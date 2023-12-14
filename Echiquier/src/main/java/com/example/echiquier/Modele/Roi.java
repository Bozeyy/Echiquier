package com.example.echiquier.Modele;

import java.util.ArrayList;

public class Roi extends Piece{

    public boolean isEchec = false;

    public Roi(int x, int y, boolean blanc) {
        super(x, y, blanc);
    }

    public int getValue(){
        return 1;
    }

    @Override
    public ArrayList<int[]> coupPossible(Echiquier echiquier) {
        ArrayList<int[]> coupPossible = new ArrayList<int[]>();

        int x = this.x;
        int y = this.y;
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                x = this.x + i;
                y = this.y + j;
                if(x >= 0 && x <= 7 && y >= 0 && y <= 7){
                    if(echiquier.plateau[x][y] == null){
                        coupPossible.add(new int[]{x,y});
                    }else if(echiquier.plateau[x][y].blanc != this.blanc){
                        coupPossible.add(new int[]{x,y});
                    }
                }
            }
        }

        return coupPossible;
    }

    @Override
    public String getPathImage() {
        if (this.blanc) {
            return "src/main/resources/RoiBlanc.png";
        } else {
            return "src/main/resources/RoiNoir.png";
        }
    }


}
