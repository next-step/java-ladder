package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line2 {
    private static final Random RANDOM = new Random();
    private static final String LINE_DELIMITER = "|";

    private List<Cross> crosses;

    public Line2(int countOfPerson) {
        createCrosses(countOfPerson);
    }
    public Line2(List<Cross> crosses) {
        this.crosses = crosses;
    }

    private void createCrosses(int countOfPerson) {
        crosses = new ArrayList<Cross>();

        Point point = Point.first(RANDOM.nextBoolean());
        for (int i = 0; i < countOfPerson; i++) {
            crosses.add(new Cross(i, i == 0 ? point : i == countOfPerson - 1 ? point.last() : point.next(RANDOM.nextBoolean())));
        }
    }

    public int move(int position) {
        return this.crosses.get(position).move();
    }

    public String getLineForPrint(String trueSymbol, String falseSymbol) {
        return LINE_DELIMITER
                + crosses.stream()
                .map(cross -> cross.getCrossForPrint(trueSymbol, falseSymbol))
                .collect(Collectors.joining(LINE_DELIMITER));
    }
}
