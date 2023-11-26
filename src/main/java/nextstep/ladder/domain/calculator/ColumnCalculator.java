package nextstep.ladder.domain.calculator;

public class ColumnCalculator implements LineCountCalculator {

    @Override
    public int calculate(int participantCount) {
        return participantCount;
    }
}
