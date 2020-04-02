package nextstep.ladder.domain;

public class Step {
    private int position;
    private boolean moveNextLine;

    private Step(int position, boolean moveNextLine) {
        this.position = position;
        this.moveNextLine = moveNextLine;
    }

    public static Step of(int position) {
        return new Step(position, false);
    }

    public int getPosition() {
        return position;
    }
}
