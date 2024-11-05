package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {
    private static final String LINE_DELIMITER = "|";
    private List<Point> points = new ArrayList<>();

    public Points(int size) {
        IntStream.range(0, size).forEach((i) -> {
            boolean isLast = i == size - 1;
            boolean prevRight = i == 0 ? false : points.get(i - 1).getRight();
            points.add(new Point(prevRight, isLast));
        });
    }

    public int getSize() {
        return this.points.size();
    }

    public String toString(String trueSymbol, String falseSymbol) {
        List<String> result = this.points
                .stream()
                .map(point -> point.getLineSymbol(trueSymbol, falseSymbol))
                .limit(this.points.size() - 1)
                .collect(Collectors.toList());

        return LINE_DELIMITER + String.join(LINE_DELIMITER, result) + LINE_DELIMITER;
    }

}
