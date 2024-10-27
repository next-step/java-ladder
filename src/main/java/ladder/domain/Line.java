package ladder.domain;

import ladder.generator.Strategy;

import java.util.*;
import java.util.stream.IntStream;

public class Line {

    private final static String ZERO_ERROR_MESSAGE = "라인은 비어있을 수 없습니다.";
    private final static String CONSECUTIVE_ERROR_MESSAGE = "연속으로 중복 될 수 없는 값이 존재합니다.";

    private final List<Boolean> points = new ArrayList<>();

    public Line(Boolean... booleans) {
        this.points.addAll(parse(booleans));
    }

    public Line(int countOfPerson, Strategy strategy) {
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
        IntStream.range(0, countOfPerson)
                .forEach(num -> addHorizontal(num, strategy));

    }

    private List<Boolean> parse(Boolean... booleans) {
        isValid(booleans);

        // List로 반환
        return Arrays.asList(booleans);
    }

    private static void isValid(Boolean... booleans) {
        if (booleans == null || booleans.length == 0) {
            throw new IllegalArgumentException(ZERO_ERROR_MESSAGE);
        }

        // Stream을 사용하여 연속된 true 값 검증
        IntStream.range(1, booleans.length)
                .filter(i -> booleans[i] && booleans[i - 1])
                .findFirst()
                .ifPresent(i -> {
                    throw new IllegalArgumentException(CONSECUTIVE_ERROR_MESSAGE);
                });
    }

    private void addHorizontal(int num, Strategy strategy) {
        if (isValid(num) && strategy.randomLadder()) {
            this.points.add(true);
            return;
        }
        this.points.add(false);
    }

    public boolean isValid(int number) {
        return !points.isEmpty() && !points.get(number - 1);
    }

    public int move(int position) {
        if(canMoveLeft(position)) {
            return position - 1;
        }
        if(canMoveRight(position)) {
            return position + 1;
        }

        return position;
    }

    private boolean canMoveLeft(int position) {
        return position > 0 && hasLine(position - 1);
    }

    private boolean canMoveRight(int position) {
        return position < points.size() && hasLine(position + 1);
    }

    private boolean hasLine(int position) {
        return points.get(position);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
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

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

}
