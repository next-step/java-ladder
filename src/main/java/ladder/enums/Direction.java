package ladder.enums;

public enum Direction {
    LEFT("LEFT",-1),RIGHT("RIGHT",1);

    private int number;

    Direction(String direction, int number){
        this.number = number;
    }

    public int number(){
        return this.number;
    }

}
