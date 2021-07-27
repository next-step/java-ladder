package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 참가자 를 표현하는 플레이어 클래스 테스트")
class PlayerTest {

    @DisplayName("플레이어는 이름을 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(Player.init("name")).isInstanceOf(Player.class);
    }

}
