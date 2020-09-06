package nextstep.ladder.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void left() {
        this.position -= 1;
    }

    public void right() {
        this.position += 1;
    }
}
