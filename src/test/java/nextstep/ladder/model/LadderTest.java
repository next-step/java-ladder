package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {
    @Test
    @DisplayName("이름 갯수만큼 leg 를 만든다.")
    public void create() {
        List<String> namesString = Arrays.asList("a", "b", "c", "d");
        Names names = new Names(namesString);
        Ladder ladder = new Ladder(names, new CoordinateValue(3), namesString.size());

        assertThat(ladder.getWidth().getValue()).isEqualTo(namesString.size());
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
        List<String> namesString = Arrays.asList("a", "b", "c", "d");
        Names names = new Names(namesString);
        Ladder ladder = new Ladder(names, new CoordinateValue(3), namesString.size());
        ladder.drawLines(strategy);

        int linesSizeSum = 0;
        for (int i = 0; i < namesString.size(); i++) {
            linesSizeSum += ladder.getLeg(new CoordinateValue(i)).getLinesSize();
        }

        assertThat(linesSizeSum).isEqualTo(linesSize);
    }
}