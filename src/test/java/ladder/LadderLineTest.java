package ladder;

import ladder.domain.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    LadderLine ladderLine = new LadderLine(4, new ForceLineStrategy()); // .-. .-. -> created line

    @ParameterizedTest
    @DisplayName("참석자의 움직임이 기대하는 대로 움직이는 지 확인")
    @MethodSource("provideAttendeesPosition")
    void IsAttendeesMovementEqualWithExpected(int input, int expected) {
        int actual = ladderLine.moveLine(input);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideAttendeesPosition() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 3),
                Arguments.of(3, 2)
        );
    }
}
