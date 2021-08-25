package nextstep.ladder.step2;

import nextstep.ladder.step2.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    @DisplayName("참여자가 2명 미만 이면 게임을 진행 할 수 없다.")
    void validPlayer() {
        assertThatThrownBy(()-> new Player("pobi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 참여자에 해당하는 Player 객체가 생성된다.")
    void create() {
        Player players = new Player("pobi,cony,crong");
        assertThat(players.getPlayerCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력 받은 참여자 중에 이름이 5글자 이상인 참여자가 있으면 예외 발생")
    void createException() {
        assertThatThrownBy(()->  new Player("pobi,geonhee")).isInstanceOf(IllegalArgumentException.class);
    }
}