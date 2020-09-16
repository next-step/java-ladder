package nextstep.ladder;

public enum Direction {
    LEFT, RIGHT, STOP;

    public static Direction makeDirection(Direction previousDirection){
        switch(previousDirection){
            case RIGHT:
                return LEFT;
            case STOP:
            case LEFT:
                return RandomGoStop.randomGoStop();
        }
        throw new IllegalArgumentException("Invalid direction");
    }
}
