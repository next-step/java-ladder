package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {

    private static final String LINE_DELIMITER = "|";
    private static final Random RANDOM = new Random();

    private List<Point> points = new ArrayList<>();

    public Points(int size) {
        IntStream.range(0, size).forEach((i) -> {
            generate(i, size);
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
