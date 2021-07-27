package nextstep.ladder.domain.init;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Fixture.LADDER_INIT_INFO_2_X_2;
import static nextstep.ladder.domain.Fixture.TWO_PLAYERS;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 게임 초기화 정보 클래스 테스트")
class LadderGameInitInfoTest {

    @DisplayName("사다리 게임은 사다리 초기화 정보와 플레이어 정보를 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(LadderGameInitInfo.of(LADDER_INIT_INFO_2_X_2, TWO_PLAYERS)).isInstanceOf(LadderGameInitInfo.class);
    }
}
