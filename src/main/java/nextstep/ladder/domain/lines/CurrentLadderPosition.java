package nextstep.ladder.domain.lines;

public class CurrentLadderPosition {

    private final int position;
    private final int height;

    public CurrentLadderPosition(int position, int height) {
        this.position = position;
        this.height = height;
    }

    public int getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }
}
