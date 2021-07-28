package nextstep.ladder.domain.init;

import nextstep.ladder.domain.player.Players;
import nextstep.ladder.exception.NullArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.LADDER_INIT_INFO_2_X_2;
import static nextstep.ladder.domain.Fixture.TWO_PLAYERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 게임 초기화 정보 클래스 테스트")
class LadderGameInitInfoTest {

    @DisplayName("사다리 게임은 사다리 초기화 정보와 플레이어 정보를 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(LadderGameInitInfo.of(LADDER_INIT_INFO_2_X_2, TWO_PLAYERS)).isInstanceOf(LadderGameInitInfo.class);
    }

    @DisplayName("초기화 정보에 null 이 포함되어 있을 경우 예외를 발생 시킨다")
    @MethodSource
    @ParameterizedTest
    void initException(LadderInitInfo ladderInitInfo, Players players) {
        assertThatThrownBy(() -> LadderGameInitInfo.of(ladderInitInfo, players)).isInstanceOf(NullArgumentException.class);
    }

    private static Stream<Arguments> initException() {
        return Stream.of(
                Arguments.of(null, TWO_PLAYERS),
                Arguments.of(LADDER_INIT_INFO_2_X_2, null),
                Arguments.of(null, null)
        );
    }
}
