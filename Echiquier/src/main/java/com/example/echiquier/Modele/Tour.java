package com.example.echiquier.Modele;

import java.util.ArrayList;

public class Tour extends Piece{

    public Tour(int x, int y, boolean blanc) {
        super(x, y, blanc);
    }

    public int getValue(){
        return 2;
    }

    public ArrayList<int[]> coupPossible(Echiquier echiquier) {
        ArrayList<int[]> coupPossible = new ArrayList<int[]>();

        int x = this.x;
        int y = this.y;
        while(x < 7){
            x++;
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
                break;
            }else{
                break;
            }
        }

        x = this.x;
        y = this.y;
        while(x > 0){
            x--;
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
                break;
            }else{
                break;
            }
        }

        x = this.x;
        y = this.y;
        while(y < 7){
            y++;
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
                break;
            }else{
                break;
            }
        }

        x = this.x;
        y = this.y;
        while(y > 0){
            y--;
            if(echiquier.plateau[x][y] == null){
                coupPossible.add(new int[]{x,y});
            }else if(echiquier.plateau[x][y].blanc != this.blanc){
                coupPossible.add(new int[]{x,y});
                break;
            }else{
                break;
            }
        }
        return coupPossible;
    }

    @Override
    public String getPathImage() {
        if (this.blanc) {
            return "src/main/resources/TourBlanc.png";
        } else {
            return "src/main/resources/TourNoir.png";
        }
    }
}
