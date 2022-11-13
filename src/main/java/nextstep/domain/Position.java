package nextstep.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int move(int point) {
        position += point;
        return position;
    }
}
