package ladder.structure.connection.result;

public enum Direction {
    RIGHT(1), STAY(0), LEFT(-1);
    private int num;

    Direction(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
