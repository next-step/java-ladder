package nextstep.ladder.domain.calculator;

public class CalculatorFactory {

    private static final String ROW = "ROW";
    private static final String COLUMN = "COLUMN";

    public int calculate(String type, int participantCount) {
        if (type.equals(ROW)) {
            return new RowCalculator().calculate(participantCount);
        }
        return new ColumnCalculator().calculate(participantCount);
    }
}
