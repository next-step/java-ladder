package ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;
import ladder.domain.Position;
import ladder.domain.direction.Direction;
import ladder.domain.direction.DirectionStrategy;
import ladder.domain.point.Point;
import ladder.domain.point.PointGenerator;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import ladder.exception.LadderGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineGeneratorTest {
    private final LineGenerator lineGenerator = new LineGenerator(new PointGenerator(new DirectionStrategy(() -> 1)));

    @ParameterizedTest
    @MethodSource("provide")
    void 라인생성_테스트(Users users, Line result) {
        assertThat(lineGenerator.generateLine(users)).isEqualTo(result);
    }

    @Test
    void 유저한명_라인생성_테스트() {
        User solo = User.of("solo", new Position(0));
        assertThrows(LadderGameException.class, () -> lineGenerator.generateLine(Users.from(Arrays.asList(solo))));
    }

    static Stream<Arguments> provide() {
        Position zero = new Position(0);
        Position one = new Position(1);
        Position two = new Position(2);
        Position three = new Position(3);
        Position four = new Position(4);

        User user1 = User.of("a", zero);
        User user2 = User.of("b", one);
        User user3 = User.of("c", two);
        User user4 = User.of("d", three);
        User user5 = User.of("e", four);

        Users users1 = Users.from(Arrays.asList(user1, user2, user3, user4));
        Users users2 = Users.from(Arrays.asList(user1, user2, user3, user4, user5));

        List<Point> points = Arrays.asList(
            new Point(zero, Direction.RIGHT),
            new Point(one, Direction.LEFT),
            new Point(two, Direction.RIGHT),
            new Point(three, Direction.LEFT)

        );
        Line line = new Line(new LinkedList<>(points));
        Line line2 = new Line(new LinkedList<>(points));
        line2.addPoint(new Point(four, Direction.DOWN));
        return Stream.of(
            Arguments.of(users1, line),
            Arguments.of(users2, line2)
        );
    }
}