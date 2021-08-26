package step2.ladderGame.domain.ladder;

public class Point {

    private final boolean status;

    public Point(boolean previousStatus) {
        this.status = previousStatus;
    }

    public boolean getStatus() {
        return this.status;
    }

}
