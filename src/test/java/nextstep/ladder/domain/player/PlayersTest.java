package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 참가자 그룹을 표현하는 플레이어즈 클래스 테스트")
class PlayersTest {

    @DisplayName("플레이어즈 그룹은 이름 리스트를 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(Players.init(Arrays.asList("nok", "cha", "x"))).isInstanceOf(Players.class);
    }
}
