package nextstep.ladder.player;

import nextstep.ladder.ladder.Ladder;
import nextstep.ladder.ladder.LadderBound;
import nextstep.ladder.ladder.stub.AlwaysAddLadderStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("플레이어 목록을 가지는 객체를 생성 한다.")
    @Test
    void create_players() {
        Players players = Players.of("pobi,honux,crong,jk");

        assertThat(players.getPlayers()).hasSize(4);
    }

    @DisplayName("사다리의 모든 라인을 순회 후 플레이어의 위치 정보를 확인한다")
    @Test
    void player_move() {
        Players players = Players.of("pobi,honux,crong,jk");
        Ladder ladder = Ladder.of(LadderBound.of(players.count() - 1, 5), new AlwaysAddLadderStrategy());
        players.getPlayers().forEach(ladder::move);

        List<Player> playersList = players.getPlayers();

        assertThat(playersList.get(0).getPosition()).isEqualTo(1);
        assertThat(playersList.get(1).getPosition()).isEqualTo(0);
        assertThat(playersList.get(2).getPosition()).isEqualTo(3);
        assertThat(playersList.get(3).getPosition()).isEqualTo(2);
    }
}