package nextstep.ladder;

class Position {
    private final int crossPosition;

    public Position(int crossPosition) {
        this.crossPosition = crossPosition;
    }

    public static Position of(int position) {
        return new Position(position);
    }

    public int toInt() {
        return crossPosition;
    }
}
