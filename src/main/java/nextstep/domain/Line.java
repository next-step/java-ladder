package nextstep.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private static final TransverseBarStrategy DEFAULT_TRANSVERSE_BAR_STRATEGY = new RandomTransverseBarStrategy();
    public static final int FIRST_POINT_INDEX = 0;
    public static final int LAST_POINT_INDEX = 1;

    private final List<Boolean> points;

    public Line(int countOfPerson) {
        this(countOfPerson, DEFAULT_TRANSVERSE_BAR_STRATEGY);
    }

    public Line(int countOfPerson, TransverseBarStrategy transverseBarStrategy) {
        this(transverseBarStrategy.draw(countOfPerson));
    }

    public Line(List<Boolean> points) {
        if (!validateNotOverlap(points)) {
            throw new IllegalArgumentException("횡단선이 겹치면 안됩니다.");
        }
        this.points = points;
    }

    private boolean validateNotOverlap(List<Boolean> points) {
        return IntStream.range(FIRST_POINT_INDEX, points.size() - LAST_POINT_INDEX)
                .mapToObj(i -> new LineValidateOverlapDto(points.get(i), points.get(i + 1)).isOverlap())
                .noneMatch(Boolean::booleanValue);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

}
