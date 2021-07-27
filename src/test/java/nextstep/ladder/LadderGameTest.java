package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Fixture.LADDER_GAME_INIT_INFO_2_X_2;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 게임 클래스 테스트")
class LadderGameTest {

    @DisplayName("사다리 게임은 사다리 게임 초기화 정보를 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(LadderGame.init(LADDER_GAME_INIT_INFO_2_X_2)).isInstanceOf(LadderGame.class);
    }
}
