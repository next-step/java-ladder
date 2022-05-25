package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @Test
    @DisplayName("이름이 5글자를 넘어가면 예외가 발생한다.")
    void 이름_생성_예외(){
        assertThatThrownBy(()->new Player("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Player 객체 생성 테스트")
    void Player_생성() {
        assertThat(new Player("test"))
                .isNotNull()
                .isInstanceOf(Player.class);
    }
}