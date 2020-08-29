package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LadderTest {

    private static Stream<Arguments> provideForCreateLadder() {
        return Stream.of(
                Arguments.of(3, 5, Arrays.asList(
                            new Line(Arrays.asList(true, false, true, false)),
                            new Line(Arrays.asList(true, false, true, false)),
                            new Line(Arrays.asList(true, false, true, false))
                )),
                Arguments.of(1, 8, Arrays.asList(
                            new Line(Arrays.asList(true, false, true, false, true, false, true))
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForCreateLadder")
    @DisplayName("Ladder 생성하기 테스트")
    public void of(int width, int countOfPoints, List<Line> lines) {
        // given
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;
        Ladder expected = new Ladder(lines);

        // when
        Ladder ladder = Ladder.of(width, countOfPoints, alwaysGenerateStrategy);

        // then
        assertThat(ladder).isEqualTo(expected);

    }

    @Test
    @DisplayName("Ladder 생성 실패 테스트")
    public void of_fail() {
        // given
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;

        // when
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of(0, 2, alwaysGenerateStrategy));

    }

}