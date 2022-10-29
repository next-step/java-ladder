package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("포인트의 인덱스가 동일한지 결과를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0,true",
            "1,false"
    })
    void isEqualIndex(int index, boolean expect) {
        assertThat(new Point(0, Direction.RIGHT).isEqualIndex(index))
                .isEqualTo(expect);
    }

    @DisplayName("")
    @ParameterizedTest
    @CsvSource({
            "RIGHT,true",
            "LEFT,false",
            "NONE,false"
    })
    void isEqualDirection(Direction direction, boolean expected) {
        assertThat(new Point(0, Direction.RIGHT).isEqualDirection(direction))
                .isEqualTo(expected);
    }

    @DisplayName("포인트의 인덱스가 인접해있고, 방향이 오른쪽, 왼쪽이라면 서로 연결되어 있어야 한다.")
    @ParameterizedTest
    @MethodSource("provideConnectedPoints")
    void isConnected(Point point, Point anotherPoint) {
        assertThat(point.isConnected(anotherPoint)).isTrue();
    }

    private static Stream<Arguments> provideConnectedPoints() {
        return Stream.of(
                Arguments.of(new Point(0, Direction.RIGHT), new Point(1, Direction.LEFT)),
                Arguments.of(new Point(1, Direction.LEFT), new Point(0, Direction.RIGHT))
        );
    }

    @DisplayName("다음 포인트가 될 수 있는 포인트가 주어지면, true를 반환해야 한다.")
    @ParameterizedTest
    @MethodSource("providePossibleNextPointCases")
    void nextPointPossible_givenPossibleCases(Point previousPoint, Point nextPoint) {
        assertThat(nextPoint.nextPointPossible(previousPoint)).isTrue();
    }

    private static Stream<Arguments> providePossibleNextPointCases() {
        return Stream.of(
                Arguments.of(new Point(0, Direction.RIGHT), new Point(1, Direction.LEFT)),
                Arguments.of(new Point(0, Direction.LEFT), new Point(1, Direction.NONE)),
                Arguments.of(new Point(0, Direction.LEFT), new Point(1, Direction.RIGHT)),
                Arguments.of(new Point(0, Direction.NONE), new Point(1, Direction.NONE)),
                Arguments.of(new Point(0, Direction.NONE), new Point(1, Direction.RIGHT))
        );
    }

    @DisplayName("다음 포인트가 될 수 없는 포인트가 주어지면, false를 반환해야 한다.")
    @ParameterizedTest
    @MethodSource("provideImpossibleNextPointCases")
    void nextPointPossible_givenImpossibleNextPointCases(Point previousPoint, Point nextPoint) {
        assertThat(nextPoint.nextPointPossible(previousPoint)).isFalse();
    }

    private static Stream<Arguments> provideImpossibleNextPointCases() {
        return Stream.of(
                Arguments.of(new Point(0, Direction.RIGHT), new Point(2, Direction.LEFT)),
                Arguments.of(new Point(0, Direction.RIGHT), new Point(1, Direction.NONE)),
                Arguments.of(new Point(0, Direction.RIGHT), new Point(1, Direction.RIGHT)),
                Arguments.of(new Point(0, Direction.LEFT), new Point(1, Direction.LEFT)),
                Arguments.of(new Point(0, Direction.NONE), new Point(1, Direction.LEFT))
        );
    }

    @DisplayName("인덱스가 0 이고, 방향이 왼쪽이 아니라면 첫 번째 포인트가 될 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"RIGHT", "NONE"})
    void firstPossible(Direction direction) {
        assertThat(new Point(0, direction).firstPossible()).isTrue();
    }


    @DisplayName("인덱스가 0 이고, 방향이 왼쪽이 아니라면 첫 번째 포인트가 될 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "0,LEFT",
            "1,RIGHT"
    })
    void firstPossible_givenImpossiblePointForFirst(int index, Direction direction) {
        assertThat(new Point(index, direction).firstPossible()).isFalse();
    }

    @DisplayName("인덱스가 총 포인트의 개수보다 1 작고, 방향이 오른쪽이 아니라면 마지막 포인트가 될 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"LEFT", "NONE"})
    void lastPoint(Direction direction) {
        assertThat(new Point(1, direction).lastPossible(2)).isTrue();
    }


    @DisplayName("인덱스가 0 이고, 방향이 왼쪽이 아니라면 첫 번째 포인트가 될 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "0,NONE",
            "1,RIGHT"
    })
    void lastPoint_givenImpossiblePointForLast(int index, Direction direction) {
        assertThat(new Point(index, direction).lastPossible(2)).isFalse();
    }

    @DisplayName("포인트의 방향에 따라 다음 라인의 포인트가 반환되야 한다.")
    @ParameterizedTest
    @CsvSource({
            "1,RIGHT,2",
            "1,LEFT,0",
            "1,NONE,1"
    })
    void getNextLinePosition(int index, Direction direction, int expected) {
        assertThat(new Point(index, direction).getNextLineIndex())
                .isEqualTo(expected);
    }

}
