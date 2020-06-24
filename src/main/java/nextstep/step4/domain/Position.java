package nextstep.step4.domain;

public class Position {
    private int breath;

    public Position(int breath) {
        this.breath = breath;
    }

    public void movePosition(Line line) {
        if (breath < line.getPointsSize() && line.getPoint(breath)) {
            ++breath;
            return;
        }

        if (breath > 0 && line.getPoint(breath - 1)) {
            --breath;
        }
    }

    public int getBreath() {
        return breath;
    }
}
