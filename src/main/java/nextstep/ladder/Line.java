package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private static final Random RANDOM = new Random();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1).forEach((i) -> {
            points.add(isLinePresentAt(i) ? false : RANDOM.nextBoolean());
        });
    }

    private boolean isLinePresentAt(int i) {
        if (i > 0 && points.get(i - 1).booleanValue()) {
            return true;
        }
        return false;
    }

    public List<Boolean> getPoints() {
        return this.points;
    }

    public String toString(String delimiter, String trueSymbol, String falseSymbol) {
        List<String> result = this.points
                .stream()
                .map(point -> getLineSymbol(point, trueSymbol, falseSymbol))
                .collect(Collectors.toList());

        return delimiter + String.join(delimiter, result) + delimiter;
    }

    private static String getLineSymbol(boolean point, String trueSymbol, String falseSymbol) {
        return point ? trueSymbol : falseSymbol;
    }
}
