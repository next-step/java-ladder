package nextstep.ladder;

class Position {
    public int crossPosition;

    public Position(int crossPosition) {
        this.crossPosition = crossPosition;
    }

    public static Position of(int position) {
        return new Position(position);
    }
}
