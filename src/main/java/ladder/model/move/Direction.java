package ladder.model.move;

public enum Direction {
    LEFT(-1), RIGHT(1);

    private int step;

    Direction(int step) {
        this.step = step;
    }

    public int getStep(){
        return step;
    }
}
