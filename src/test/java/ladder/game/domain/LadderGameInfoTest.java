package ladder.game.domain;

import ladder.player.domain.Players;
import ladder.prize.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameInfoTest {

    @DisplayName("참여자와 결과를 입력하면 게임정보를 생성할 수 있다.")
    @Test
    public void newGameInfoTest() {
        Players players = Players.of(Arrays.asList("ljw", "jwee0330"));
        Prizes prizes = Prizes.of(Arrays.asList("1등", "꽝"));

        LadderGameInfo ladderGameInfo = LadderGameInfo.of(players, prizes);

        assertThat(ladderGameInfo).satisfies(target -> {
            assertThat(target.getPlayers()).isEqualTo(players);
            assertThat(target.getPrizes()).isEqualTo(prizes);
        });
    }

}
