package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("게임 참가자 를 표현하는 플레이어 클래스 테스트")
class PlayerTest {

    @DisplayName("플레이어는 이름을 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(Player.init("name")).isInstanceOf(Player.class);
    }

    @DisplayName("플레이어 이름이 5글자를 초과하는 경우 예외를 발생 시킨다")
    @Test
    void initException() {
        assertThatThrownBy(() -> Player.init("nokchax")).isInstanceOf(IllegalArgumentException.class);
    }
}
