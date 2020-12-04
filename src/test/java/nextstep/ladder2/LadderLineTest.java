package nextstep.ladder2;

import nextstep.ladder.domain.BooleanGenerator;
import nextstep.ladder.domain.TestingBooleanGenerator;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static nextstep.ladder.domain.BooleanGenerator.generateBooleans;
import static nextstep.ladder.utils.BinaryOperators.nope;
import static nextstep.ladder2.LadderLineTest.Lists.last;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 * <p>
 * * 넓이(플레이어 수)를 입력받는다.
 * * 플레이어 수 만큼 Point 들을 생성한다
 * * Point 간 이동을 대리하는 move 메시지를 제공한다.
 */
public class LadderLineTest {
    @Test
    void create() {
        assertThat(LadderLine.of(3).sizeOfPoints()).isEqualTo(3);
    }

    @Test
    void createWithPoint() {
        assertThat(LadderLine.of(3, new TestingBooleanGenerator(true, false)))
                .isEqualTo(new LadderLine(buildPoints(true, false)));
    }

    private List<Point> buildPoints(Boolean... booleans) {
        return new PointListBuilder(booleans).build();
    }

    static class LadderLine {
        private static final Random RANDOM = new Random();
        private final List<Point> points;

        LadderLine(List<Point> points) {
            this.points = points;
        }

        public static LadderLine of(int size) {
            return of(size, RANDOM::nextBoolean);
        }

        static LadderLine of(int size, BooleanGenerator generator) {
            return new LadderLine(new PointListBuilder(
                    generateBooleans(excludeFirstPoint(size), generator)).build());
        }

        private static int excludeFirstPoint(int size) {
            return size - 1;
        }

        int sizeOfPoints() {
            return points.size();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            LadderLine that = (LadderLine) o;
            return points.equals(that.points);
        }

        @Override
        public int hashCode() {
            return Objects.hash(points);
        }
    }

    static class Lists {
        public static <T> T last(List<T> list) {
            return list.get(list.size() - 1);
        }
    }

    static class PointListBuilder {
        private final Boolean[] rightMovables;

        public PointListBuilder(Boolean[] rightMovables) {
            this.rightMovables = rightMovables;
        }

        private List<Point> build() {
            List<Point> result = Arrays.stream(rightMovables)
                    .collect(collectPointsTo(ArrayList::new));
            addLast(result);
            return result;
        }

        private Collector<Boolean, List<Point>, List<Point>> collectPointsTo(Supplier<List<Point>> supplier) {
            return Collector.of(supplier,
                                this::addPoint,
                                nope()
            );
        }

        private void addPoint(List<Point> list, Boolean right) {
            if (list.isEmpty()) {
                addFirst(list, right);
                return;
            }
            addNext(list, right);
        }

        private void addFirst(List<Point> list, Boolean right) {
            list.add(Point.first(right));
        }

        private static void addNext(List<Point> list, Boolean right) {
            list.add(last(list).next(right));
        }

        private void addLast(List<Point> result) {
            result.add(last(result).last());
        }
    }
}
