package nextstep.ladder.domain;

public enum Direction {
    DOWN(0, "|     "),
    RIGHT(1, "|-----"),
    LEFT(-1, "|     ");

    public int nextIndex;
    public String displayChar;

    Direction(int nextIndex, String displayChar) {
        this.nextIndex = nextIndex;
        this.displayChar = displayChar;
    }
}
