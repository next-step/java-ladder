package nextstep.step3.domain;

public class Position {
    private int breath;

    public Position(int breath) {
        this.breath = breath;
    }

    public void movePosition(Line line) {
        if (breath < line.getPoints().size() && line.getPoints().get(breath)) {
            ++breath;
            return;
        }

        if (breath > 0 && line.getPoints().get(breath - 1)) {
            --breath;
        }
    }

    public int getBreath() {
        return breath;
    }
}
