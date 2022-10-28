package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderLineTest {

    private final LadderLine line = LadderLine.from(Direction.RIGHT, Direction.LEFT, Direction.NONE);

    @DisplayName("사다리 라인의 포인트의 인덱스는 0부터 순차적으로 1씩 증가하지 않으면 예외가 발생해야 한다.")
    @Test
    void create_whenPointIndexIsNotIncrementedSequentially() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(List.of(
                        new Point(0, Direction.RIGHT),
                        new Point(2, Direction.LEFT),
                        new Point(1, Direction.NONE)
                )));
    }

    @DisplayName("사다리 라인의 포인트는 오른쪽 방향이 나오면 다음 포인트는 왼쪽 방향이 나오지 않으면 예외가 발생해야 한다.")
    @Test
    void create_whenDirectionIsRight_givenNextDirectionIsNotLeft() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(List.of(
                        new Point(0, Direction.NONE),
                        new Point(1, Direction.RIGHT),
                        new Point(2, Direction.NONE)
                )));
    }

    @DisplayName("사다리 라인의 첫 번째 포인트의 방향이 왼쪽이거나 마지막 포인트의 방향이 오른쪽이라면 예외가 발생해야 한다.")
    @ParameterizedTest
    @MethodSource("provideInvalidEndPoints")
    void create_givenInvalidEndPoints(List<Point> points) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(points));
    }

    private static Stream<Arguments> provideInvalidEndPoints() {
        return Stream.of(
                Arguments.of(List.of(new Point(0, Direction.LEFT), new Point(1, Direction.NONE))),
                Arguments.of(List.of(new Point(0, Direction.NONE), new Point(1, Direction.RIGHT)))
        );
    }

    @DisplayName("포인트가 1개만 주어질 때, 포인트의 방향이 존재하면 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"RIGHT", "LEFT"})
    void create_givenOnePointWithDirection(Direction direction) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(List.of(new Point(0, direction))));
    }

    @DisplayName("여러 개의 포인트 방향을 받아서 사다리 라인을 생성해야 한다.")
    @Test
    void from() {
        assertThat(LadderLine.from(Direction.RIGHT, Direction.LEFT, Direction.NONE))
                .isEqualTo(new LadderLine(List.of(
                        new Point(0, Direction.RIGHT),
                        new Point(1, Direction.LEFT),
                        new Point(2, Direction.NONE)
                )));
    }

    @DisplayName("인덱스가 주어지면 해당 인덱스의 포인트를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0,RIGHT",
            "1,LEFT",
            "2,NONE"
    })
    void get(int index, Direction expectedDirection) {
        assertThat(line.get(index)).isEqualTo(new Point(index, expectedDirection));
    }

    @DisplayName("사다리 가로 연결 라인의 인덱스가 주어지면, 해당 라인이 연결되어 있는지 여부를 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0,true",
            "1,false"
    })
    void isConnected(int indexOfConnection, boolean expected) {
        assertThat(line.isConnected(indexOfConnection)).isEqualTo(expected);
    }

}
