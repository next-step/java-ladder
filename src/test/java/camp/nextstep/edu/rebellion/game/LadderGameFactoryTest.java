package camp.nextstep.edu.rebellion.game;

import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.game.origin.OriginLadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameFactoryTest {
    @DisplayName("mode 에 해당하는 사다리 게임을 잘 가져오는지 확인")
    @Test
    public void resolveTest() {
        // given
        Players players = new Players("A,B,C");
        int rows = 5;

        // when
        LadderGame ladderGame = LadderGameFactory.resolve(LadderGameMode.ORIGIN, players, 5);

        // then
        assertThat(ladderGame.getClass()).isEqualTo(OriginLadderGame.class);
    }
}
