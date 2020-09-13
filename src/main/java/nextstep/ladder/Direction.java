package nextstep.ladder;

public enum Direction {
    LEFT(-1), RIGTH(1), STOP(0);

    private int position;

    Direction(int position) {
        this.position = position;
    }

    public Direction of(int position){
        for(Direction direction : values()){
            if(direction.getPosition() == position){
                return direction;
            }
        }

        throw new IllegalArgumentException("invalid position");
    }

    public static Direction makeDirection(Direction previousDirection){
        switch(previousDirection){
            case RIGTH:
                return LEFT;
            case STOP:
            case LEFT:
                return RandomGoStop.randomGoStop();
        }
        throw new IllegalArgumentException("Invalid direction");
    }

    private int getPosition(){
        return position;
    }


}
