package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {
    private static final Random RANDOM = new Random();
    private static final String LINE_DELIMITER = "|";
    private List<Point> points = new ArrayList<>();

    public Points(int size) {
        IntStream.range(0, size).forEach((i) -> {
            boolean prevRight = i == 0 ? false : points.get(i - 1).getRight();
            boolean right = i == size - 1 ? false : generateRandomRightPoint(prevRight);

            points.add(new Point(prevRight, right));
        });
    }

    public Points(List<Point> points) {
        this.points = points;
    }

    private boolean generateRandomRightPoint(boolean prev) {
        return prev ? false : RANDOM.nextBoolean();
    }

    public int getSize() {
        return this.points.size();
    }

    public List<Point> getValues() {
        return this.points;
    }

    public String toString(String trueSymbol, String falseSymbol) {
        List<String> result = this.points
                .stream()
                .map(point -> point.getLineSymbol(trueSymbol, falseSymbol))
                .limit(this.points.size() - 1)
                .collect(Collectors.toList());

        return LINE_DELIMITER + String.join(LINE_DELIMITER, result) + LINE_DELIMITER;
    }

    public List<Integer> getResultIndexs() {
        return IntStream.range(0, points.size()).map((i) -> points.get(i).getResultIndex(i))
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return points.stream().map(Point::toString).collect(Collectors.toList()).toString();
    }
}
