package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import nextstep.ladder.strategy.DrawLineStrategy;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InterSpacesTest {

    @ParameterizedTest
    @MethodSource("provideGameSettings")
    @DisplayName("마지막 사다리의 오른편에는 절대로 가로라인을 가질수 없다.")
    void checkLastInterSpaceBlank(int playersCount, DrawLineStrategy strategy) {

        InterSpaces interSpaces = new InterSpaces(playersCount, strategy);
        int lastIndex = interSpaces.value().size() - 1;
        assertThat(interSpaces.value().get(lastIndex)).isEqualTo(InterSpace.getBlankInterSpace());

    }


    private static Stream<Arguments> provideGameSettings() {

        return Stream.of(
            Arguments.of(2,RandomDrawLineStrategy.getInstance())
        );
    }
}