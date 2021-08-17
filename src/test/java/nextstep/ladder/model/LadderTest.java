package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    @Test
    @DisplayName("이름 갯수만큼 leg 를 만든다.")
    public void create() {
        Names names = new Names(Arrays.asList("a", "b", "c", "d"));
        Ladder ladder = new Ladder(names, new CoordinateValue(3));

        assertThat(ladder.getLegs().size()).isEqualTo(names.size());
        assertThat(ladder.getHeight()).isEqualTo(new CoordinateValue(3));
    }

    public static Stream<Arguments> drawLineProvider() {
        return Stream.of(
            Arguments.of(
                new NoLineDrawStrategy(), 0
            ),
            Arguments.of(
                new YesLineDrawStrategy(), 12
            )
        );
    }

    @ParameterizedTest
    @DisplayName("strategy 에 따라 line 을 만든다.")
    @MethodSource("drawLineProvider")
    public void drawLine(LineDrawStrategy strategy, int linesSize) {
        Names names = new Names(Arrays.asList("a", "b", "c", "d"));
        Ladder ladder = new Ladder(names, new CoordinateValue(3));
        ladder.drawLines(strategy);

        assertThat(ladder.getLegs().stream().mapToInt(Leg::getLinesSize).sum()).isEqualTo(linesSize);
    }
}