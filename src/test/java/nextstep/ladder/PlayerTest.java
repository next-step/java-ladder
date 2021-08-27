package nextstep.ladder;

import nextstep.ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("참여자가 2명 미만 이면 게임을 진행 할 수 없다.")
    void validPlayer() {
        assertThatThrownBy(()-> new Players("pobi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 참여자에 해당하는 Player 객체가 생성된다.")
    void create() {
        Players players = new Players("pobi,cony,crong");
        assertThat(players.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 받은 참여자 중에 이름이 5글자 이상인 참여자가 있으면 예외 발생")
    void createException() {
        assertThatThrownBy(()->  new Players("pobi,geonhee")).isInstanceOf(IllegalArgumentException.class);
    }
}