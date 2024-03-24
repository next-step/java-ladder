package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    public static final int MIN_COUNT = 2;
    private static final Random RANDOM = new Random();

    private final List<Boolean> points;

    public static Line from(int countOfPerson) {
        return new Line(create(countOfPerson));
    }

    public static Line from(Boolean... points) {
        return new Line(List.of(points));
    }

    private static List<Boolean> create(int countOfPerson) {
        if (countOfPerson < MIN_COUNT) {
            throw new IllegalArgumentException("최소 인원은 " + MIN_COUNT + "명 입니다");
        }

        List<Boolean> result = new ArrayList<>();
        result.add(canConnect());
        for (int i = 1; i < countOfPerson - 1; i++) {
            result.add(isBuildable(result.get(i - 1)));
        }

        return result;
    }

    private static boolean isBuildable(boolean prev) {
        return !prev && canConnect();
    }

    private static boolean canConnect() {
        return RANDOM.nextBoolean();
    }

    private Line(List<Boolean> points) {
        assertNullOrEmpty(points);
        assertInvalidLine(points);
        this.points = points;
    }

    private void assertNullOrEmpty(List<Boolean> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("라인 정보가 비어있습니다");
        }
    }

    private void assertInvalidLine(List<Boolean> points) {
        IntStream.rangeClosed(0, points.size() - 2)
                .forEach(idx -> checkContinuousLine(points.get(idx), points.get(idx + 1)));
    }

    private void checkContinuousLine(boolean prev, boolean next) {
        if (prev && next) {
            throw new IllegalArgumentException("라인이 겹치지 않아야 합니다");
        }
    }

    public Player move(Player player) {
        if (movableLeft(player)) {
            return player.moveLeft();
        }

        if (movableRight(player)) {
            return player.moveRight();
        }

        return player;
    }

    private boolean movableLeft(Player player) {
        return player.greaterThan(startLine()) && isConnected(player.getPosition() - 1);
    }

    private boolean movableRight(Player player) {
        return player.lessThan(endLine()) && isConnected(player.getPosition());
    }

    private int startLine() {
        return 0;
    }

    private int endLine() {
        return this.points.size();
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(this.points);
    }

    private boolean isConnected(int position) {
        return this.points.get(position);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Line line = (Line) other;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
