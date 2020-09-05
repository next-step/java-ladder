package nextstep.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final TransverseBarStrategy DEFAULT_TRANSVERSE_BAR_STRATEGY = new RandomTransverseBarStrategy();

    private List<Boolean> points;

    public Line(int countOfPerson) {
        this(drawTransverseBar(countOfPerson, DEFAULT_TRANSVERSE_BAR_STRATEGY));
    }

    public Line(List<Boolean> points) {
        if (!validateNotOverlap(points)) {
            throw new IllegalArgumentException("횡단선이 겹치면 안됩니다.");
        }
        this.points = points;
    }

    public static boolean validateHasOneOrMoreTransverseBar(List<Boolean> line) {
        return line.stream()
                .anyMatch(Boolean::booleanValue);
    }

    public static boolean validateNotOverlap(List<Boolean> line) {
        return IntStream.range(0, line.size() - 1)
                .mapToObj(i -> new LineValidateOverlapDto(line.get(i), line.get(i + 1)).isOverlap())
                .noneMatch(Boolean::booleanValue);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public static List<Boolean> drawTransverseBar(int countOfPerson, TransverseBarStrategy transverseBarStrategy) {
        return transverseBarStrategy.draw(countOfPerson);
    }

    private static class LineValidateOverlapDto {

        private Boolean leftTransverseBar;
        private Boolean rightTransverseBar;

        public LineValidateOverlapDto(Boolean leftTransverseBar, Boolean rightTransverseBar) {
            this.leftTransverseBar = leftTransverseBar;
            this.rightTransverseBar = rightTransverseBar;
        }

        public boolean isOverlap() {
            return leftTransverseBar && rightTransverseBar;
        }

    }

}
