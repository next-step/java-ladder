package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StepTest {

    @Test
    @DisplayName("첫번째 step 생성하기")
    void first() {
        // given
        boolean generateRight = true;
        Step expected = new Step(0, new Direction(false, true));

        // when
        Step firstStep = Step.first(generateRight);

        // then
        assertThat(firstStep).isEqualTo(expected);

    }

    @Test
    @DisplayName("마지막 step 생성하기 : 왼쪽에 다리가 있을 때 ")
    void last_has_before_step() {
        // given
        int lastPosition = 5;
        Step beforeStep = new Step(lastPosition - 1, new Direction(false, true));
        Step expected = new Step(lastPosition, new Direction(true, false));

        // when
        Step result = beforeStep.last();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("마지막 step 생성하기 : 왼쪽에 다리가 을 때 ")
    void last_does_not_has_before_step() {
        // given
        int lastPosition = 5;
        Step beforeStep = new Step(lastPosition - 1, new Direction(false, false));
        Step expected = new Step(lastPosition, new Direction(false, false));

        // when
        Step result = beforeStep.last();

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideForNext() {
        return Stream.of(
                Arguments.of(3, true, new Direction(true, false), new Direction(false, true)),
                Arguments.of(1, true, new Direction(false, true), new Direction(true, false)),
                Arguments.of(2, false, new Direction(false, false), new Direction(false, false))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForNext")
    @DisplayName("다음 step 생성하기")
    void next(int position, boolean generateRight, Direction direction, Direction expectedDirection) {
        // given
        Step step = new Step(position, direction);
        Step expected = new Step(position + 1, expectedDirection);

        // when
        Step result = step.next(generateRight);

        // then
        assertThat(result).isEqualTo(expected);

    }

    private static Stream<Arguments> provideForMove() {
        return Stream.of(
                Arguments.of(3, new Direction(true, false), 2),
                Arguments.of(3, new Direction(false, true), 4),
                Arguments.of(3, new Direction(false, false), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideForMove")
    @DisplayName("위치 이동하기")
    void move(int position, Direction direction, int expected) {
        // given
        Step step = new Step(position, direction);

        // when
        int result = step.move();

        // then
        assertThat(result).isEqualTo(expected);
    }

}
