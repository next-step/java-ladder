package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final String LINE = "-----";
    private static final String NO_LINE = "     ";
    private static final String SEPARATOR = "|";
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1)
                .forEach(count -> {
                    if (count > 0 && this.points.get(count - 1)) {
                        this.points.add(false);
                        return;
                    }
                    this.points.add(this.randomLine());
                });
    }

    private boolean randomLine() {
        return new Random().nextInt(2) == 0;
    }

    public String printLine() {
        String result = "";
        for (Boolean point : this.points) {
            String isLine = point ? LINE : NO_LINE;
            result += SEPARATOR + isLine;
        }
        return result + SEPARATOR;
    }
}
