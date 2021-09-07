package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.stream.Stream;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {

    @ParameterizedTest
    @MethodSource("provideGameSettings")
    @DisplayName("1 x 2 이상의 사다리를 생성할수있다.")
    void createLadder(LadderGameSettings settings) {
        assertThatCode(() -> LadderGame.from(settings))
            .doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideGameSettings() {

        return Stream.of(
            Arguments.of(LadderGameSettings.of(LadderSize.of(1, 2), new RandomDrawLineStrategy())),
            Arguments.of(LadderGameSettings.of(LadderSize.of(2, 1), new RandomDrawLineStrategy())),
            Arguments.of(LadderGameSettings.of(LadderSize.of(2, 2), new RandomDrawLineStrategy())),
            Arguments.of(LadderGameSettings.of(LadderSize.of(10, 10), new RandomDrawLineStrategy()))
        );
    }

}