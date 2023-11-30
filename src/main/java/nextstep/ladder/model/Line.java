package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final RandomLineGenerator randomLineGenerator = RandomLineGenerator.getInstance();
    private final List<Boolean> line;

    private Line(List<Boolean> line) {
        this.line = line;
    }

    public static Line from(int count) {
        List<Boolean> collect = IntStream.range(0, count)
            .mapToObj(step -> randomLineGenerator.randomStep())
            .collect(Collectors.toList());

        for (int i = 1; i < collect.size(); i++) {
            collect.set(i, neverOverlapLine(collect.get(i), collect.get(i - 1)));
        }

        return new Line(collect);
    }

    private static Boolean neverOverlapLine(Boolean step, Boolean previousStep) {
        if (step.equals(true) && previousStep.equals(true)) {
            return false;
        }
        return step;
    }

    public List<Boolean> line() {
        return line;
    }

    public int lineSize() {
        return line.size();
    }

}
