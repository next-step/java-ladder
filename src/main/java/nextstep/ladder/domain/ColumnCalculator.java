package nextstep.ladder.domain;

public class ColumnCalculator implements LineCountCalculator {

    @Override
    public int calculate(int participantCount) {
        return participantCount;
    }
}
