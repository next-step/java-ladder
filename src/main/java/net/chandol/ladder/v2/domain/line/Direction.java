package net.chandol.ladder.v2.domain.line;

public enum Direction {
    STRAIGHT, LEFT, RIGHT;

    public int nextLineNumber(int currentLine) {
        switch (this) {
            case RIGHT:
                return currentLine + 1;
            case LEFT:
                return currentLine - 1;
            case STRAIGHT:
                return currentLine;
            default:
                throw new IllegalStateException();
        }
    }
}
