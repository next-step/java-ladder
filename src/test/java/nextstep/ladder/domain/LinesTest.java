package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("가로줄들")
class LinesTest {

    @DisplayName("[성공] 생성")
    @ParameterizedTest
    @CsvSource(value = {
        "10,5"
    })
    public void create(final int height, final int playerCount) {
        // given

        // when
        final Lines lines = Lines.of(height, playerCount);

        // then
        assertThat(lines.size()).isEqualTo(height);
        assertThat(lines.getLines().get(0).size()).isEqualTo(playerCount + 1);
    }

    private static final Lines LINES = new Lines(Arrays.asList(
        Line.of(Arrays.asList(false, true, false, false, true, false)),
        Line.of(Arrays.asList(false, true, false, true, false, false)),
        Line.of(Arrays.asList(false, false, true, false, true, false)),
        Line.of(Arrays.asList(false, false, true, false, true, false)),
        Line.of(Arrays.asList(false, true, false, true, false, false)),
        Line.of(Arrays.asList(false, false, true, false, true, false)))
    );

    public static Stream<Arguments> goal() {
        return Stream.of(
            Arguments.of(LINES, 0, 2),
            Arguments.of(LINES, 1, 0),
            Arguments.of(LINES, 2, 1),
            Arguments.of(LINES, 3, 3),
            Arguments.of(LINES, 4, 4)
        );
    }

    @DisplayName("[성공] 도착지 index (최종 결과)")
    @ParameterizedTest
    @MethodSource("goal")
    public void goal(final Lines lines, final int start, final int expected) {
        // given

        // when
        final int goal = lines.goal(start);

        // then
        assertThat(goal).isEqualTo(expected);
    }
}
