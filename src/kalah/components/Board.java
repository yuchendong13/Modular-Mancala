package kalah.components;

import java.util.LinkedList;

public class Board {
    LinkedList<Pit> pits;

    public Board() {
        this.pits = new LinkedList<Pit>();
        for(int i = 0; i < 6; i++) {
            this.pits.add(new House(i,4));
        }
        this.pits.add(new Store(1));
        for(int i = 7; i < 13; i++) {
            this.pits.add(new House(i,4));
        }
        this.pits.add(new Store(2));

        for(int i = 0; i < 13; i++) {
            this.pits.get(i).setNext(this.pits.get(i+1));
        }
        this.pits.get(13).setNext(this.pits.get(0));

        for(int i = 1; i < 14; i++) {
            this.pits.get(i).setPrev(this.pits.get(i-1));
        }
        this.pits.get(0).setPrev(this.pits.get(13));
    }

    public LinkedList<Pit> getPits() {
        return this.pits;
    }

    public boolean playerPitsEmpty(int player) {
        boolean playerPitsEmpty = true;
        if(player == 1) {
            for(int i = 0; i < 6; i++) {
                if(!(this.pits.get(i).getSeeds() == 0)) {
                    playerPitsEmpty = false;
                    break;
                }
            }
        } else{
            for(int i = 7; i < 13; i++) {
                if(!(this.pits.get(i).getSeeds() == 0)) {
                    playerPitsEmpty = false;
                    break;
                }
            }
        }
        return playerPitsEmpty;
    }

    public int captureHelper(int house) {
        switch (house) {
            case 0:
                return 12;
            case 1:
                return 11;
            case 2:
                return 10;
            case 3:
                return 9;
            case 4:
                return 8;
            case 5:
                return 7;
            case 7:
                return 5;
            case 8:
                return 4;
            case 9:
                return 3;
            case 10:
                return 2;
            case 11:
                return 1;
            case 12:
                return 0;
            default:
                return -1;
        }
    }
}
