package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import nextstep.ladder.strategy.DrawLineStrategy;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderGameSettingsTest {

    @Test
    @DisplayName("사다리게임 세팅정보를 설정할수있다.")
    void createGameSetting() {
        LadderSize ladderSize = LadderSize.of(2, 2);
        DrawLineStrategy strategy = new RandomDrawLineStrategy();

        assertThatCode(() -> LadderGameSettings.of(ladderSize, strategy))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("provideWrongGameSettings")
    @DisplayName("사다리게임세팅은 사다리사이즈와 가로라인 긋기방법 둘다 설정되지 않으면 예외를 던진다.")
    void createGameSettingFail(LadderSize ladderSize, DrawLineStrategy strategy) {

        assertThatThrownBy(() -> LadderGameSettings.of(ladderSize, strategy))
            .isInstanceOf(NullPointerException.class);

    }


    private static Stream<Arguments> provideWrongGameSettings() {
        return Stream.of(
            Arguments.of(LadderSize.of(2, 2), null),
            Arguments.of(null, new RandomDrawLineStrategy()),
            Arguments.of(null, null)
        );
    }
}