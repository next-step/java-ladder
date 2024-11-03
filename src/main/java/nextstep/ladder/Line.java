package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points = new ArrayList<>();
    private static final Random RANDOM = new Random();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson).forEach((i) -> {
            generate(i, countOfPerson);
        });
    }

    private void generate(int i, int size) {
        boolean left = i == 0 ? false : isLinePresentAt(i);
        boolean right = i == size - 1 ? false : (isLinePresentAt(i) ? false : RANDOM.nextBoolean());

        points.add(new Point(left, right));
    }

    private boolean isLinePresentAt(int i) {
        return i > 0 && points.get(i - 1).getRight();
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public String toString(String delimiter, String trueSymbol, String falseSymbol) {
        List<String> result = this.points
                .stream()
                .map(point -> getLineSymbol(point.getRight(), trueSymbol, falseSymbol))
                .limit(this.points.size() - 1)
                .collect(Collectors.toList());

        return delimiter + String.join(delimiter, result) + delimiter;
    }

    private static String getLineSymbol(boolean point, String trueSymbol, String falseSymbol) {
        return point ? trueSymbol : falseSymbol;
    }
}
