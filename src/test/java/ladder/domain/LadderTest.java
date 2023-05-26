package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

    @DisplayName("line 존재시 바로 옆에 line 중복 불가")
    @ParameterizedTest
    @MethodSource("addArgs")
    void addTest(int countOfPerson, int height, Ladder expected) {
        assertThat(Ladder.create(countOfPerson, height, () -> true)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("nonAddArgs")
    void nonAddTest(int countOfPerson, int height, Ladder expected) {
        assertThat(Ladder.create(countOfPerson, height, () -> false)).isEqualTo(expected);
    }

    @Test
    void Ladder_height_0이하() {
        assertThatThrownBy(() -> Ladder.create(2, 0, () -> true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사다리 높이는 양수 값을 가져야합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void Ladder_countOfPerson_1이하() {
        assertThatThrownBy(() -> Ladder.create(2, 0, () -> true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사다리 높이는 양수 값을 가져야합니다.");
    }

    @Test
    void execute() {
        Ladder ladder = new Ladder(List.of(
            new HorizontalLine(List.of(
                new Point(0, DirectionTest.rightDirection),
                new Point(1, DirectionTest.leftDirection)
            )),
            new HorizontalLine(List.of(
                new Point(0, DirectionTest.nonDirection),
                new Point(1, DirectionTest.nonDirection)
            ))));

        assertThat(ladder.execute(new Users(new String[]{"a", "b"}),
            Results.create(new String[]{"0", "1"}, 2)))
            .contains(entry(new User("b"), "0"), entry(new User("a"), "1"));
    }

    static Stream<Arguments> addArgs() {
        return Stream.of(
            Arguments.of(2, 2, new Ladder(List.of(
                new HorizontalLine(List.of(
                    new Point(0, DirectionTest.rightDirection),
                    new Point(1, DirectionTest.leftDirection)
                )),
                new HorizontalLine(List.of(
                    new Point(0, DirectionTest.rightDirection),
                    new Point(1, DirectionTest.leftDirection)
                ))))),
            Arguments.of(3, 2, new Ladder(List.of(
                new HorizontalLine(List.of(
                    new Point(0, DirectionTest.rightDirection),
                    new Point(1, DirectionTest.leftDirection),
                    new Point(2, DirectionTest.nonDirection)
                )),
                new HorizontalLine(List.of(
                    new Point(0, DirectionTest.rightDirection),
                    new Point(1, DirectionTest.leftDirection),
                    new Point(2, DirectionTest.nonDirection)
                ))
            )))
        );
    }

    static Stream<Arguments> nonAddArgs() {
        return Stream.of(
            Arguments.of(2, 2, new Ladder(List.of(new HorizontalLine(List.of(
                    new Point(0, DirectionTest.nonDirection),
                    new Point(1, DirectionTest.nonDirection)
                )),
                new HorizontalLine(List.of(
                    new Point(0, DirectionTest.nonDirection),
                    new Point(1, DirectionTest.nonDirection)
                )))))
        );
    }
}
