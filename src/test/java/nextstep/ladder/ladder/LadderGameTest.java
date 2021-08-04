package nextstep.ladder.ladder;

import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.player.Player;
import nextstep.ladder.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @DisplayName("사다리의 모든 라인을 순회 후 플레이어의 위치 정보를 확인한다")
    @Test
    void player_move() {
        Players players = Players.of("pobi,honux,crong,jk");
        Ladder ladder = Ladder.of(LadderBound.of(players.count() - 1, 5), LadderFactory.alwaysAddLadderStrategy());
        LadderGame ladderGame = new LadderGame(players, ladder);
        ladderGame.play();

        List<Player> playersList = players.getPlayers();

        assertThat(playersList.get(0).getPosition()).isEqualTo(1);
        assertThat(playersList.get(1).getPosition()).isEqualTo(0);
        assertThat(playersList.get(2).getPosition()).isEqualTo(3);
        assertThat(playersList.get(3).getPosition()).isEqualTo(2);
    }

}