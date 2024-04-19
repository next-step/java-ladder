package nextstep.ladder;

public class Position {
    int position;

    public Position(int position) {
        this.position = position;
    }

    public void rightMove() {
        position++;
    }

    public void leftMove() {
        position--;
    }

    public int getPosition() {
        return position;
    }

}
