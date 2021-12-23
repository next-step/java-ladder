package nextstep.ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import nextstep.ladder.domain.line.LineGenerateStrategy;

public class Line extends FirstClassList<Boolean> {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private Line(final List<Boolean> points) {
        super(points);
    }

    public static Line of (final PointCount count, final LineGenerateStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("invalid input: strategy cannot be null");
        }

        return new Line(strategy.generate(count));
    }

    public static Line of(final PlayerCount playerCount, final LineGenerateStrategy strategy) {
        return of(PointCount.of(playerCount), strategy);
    }

    public static Line of(final int count, final LineGenerateStrategy strategy) {
        return of(PointCount.of(count), strategy);
    }

    public List<Integer> move(List<Integer> position) {
        return position.stream()
                .map(this::move)
                .collect(Collectors.toList());
    }

    // todo refactor: 포인트가 있는지는 Optional로 처리해버려서 필요가 없고, 그저 외부값인 index와 상수의 연산뿐이다.
    // todo refactor: 따라서 내부 연산이 본래 전달되는 값을 필요로 하지 않아 메소드 참조로 바꿀 수 없느데, 이게 이상한 점이지 않을까?
    int move(int index) {
        return hasPoint(index).map(point -> index + RIGHT)
                .orElse(hasPoint(index + LEFT).map(point -> index + LEFT)
                        .orElse(index));
    }

    Optional<Boolean> hasPoint(int index) {
        return elementOfOpt(index).filter(this::isPoint);
    }

    boolean isPoint(boolean point) {
        return point;
    }

    @Override
    public String toString() {
        return "Line {" +
                super.toString() +
                '}';
    }
}
