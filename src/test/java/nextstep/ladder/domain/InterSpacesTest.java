package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InterSpacesTest {

    @ParameterizedTest
    @MethodSource("provideGameSettings")
    @DisplayName("마지막 사다리의 오른편에는 절대로 가로라인을 가질수 없다.")
    void checkLastInterSpaceBlank(LadderDrawingSettings settings) {

        InterSpaces interSpaces = new InterSpaces(settings);
        int lastIndex = interSpaces.value().size() - 1;
        assertThat(interSpaces.value().get(lastIndex)).isEqualTo(InterSpace.getBlankInterSpace());

    }


    private static Stream<Arguments> provideGameSettings() {

        return Stream.of(
            Arguments
                .of(LadderDrawingSettings.of(LadderSize.of(2, 1), new RandomDrawLineStrategy()), 2),
            Arguments
                .of(LadderDrawingSettings.of(LadderSize.of(5, 5), new RandomDrawLineStrategy()), 5),
            Arguments
                .of(LadderDrawingSettings.of(LadderSize.of(10, 10), new RandomDrawLineStrategy()), 10)
        );
    }
}