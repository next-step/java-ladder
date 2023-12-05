package ladder.domain.ladder;

public enum LadderConnection {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int indexDirection;

    LadderConnection(int indexDirection) {
        this.indexDirection = indexDirection;
    }

    public int nextColumnOf(int columnIndex) {
        return columnIndex + indexDirection;
    }
}
