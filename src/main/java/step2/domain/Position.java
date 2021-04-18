package step2.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    private void goPosition() {
        position++;
    }

    private void backPosition() {
        position--;
    }

    public int getPosition() {
        return position;
    }

    public int previous(Line line) {
        if (line.getPoint(position -1)) {
            backPosition();
        }

        return position;
    }

    public int next(Line line) {
        if (line.getPoint(position)) {
            goPosition();
        }

        return position;
    }
}
