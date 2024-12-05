package nextstep.ladder.domain.laddergame.position;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderTest;
import nextstep.ladder.domain.player.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PlayerPositionsTest {

    private PlayerPositions playerPositions;

    @BeforeEach
    void setUpPlayerPositions() {
        Ladder ladder = LadderTest.getLadder();

        List<Positions> positionsList = new ArrayList<>();

        for (int i = 0; i < ladder.getPlayers().size(); i++) {
            Positions positions = new Positions();
            positionsList.add(positions.add(ladder.getLines(), i));
        }

        playerPositions = new PlayerPositions(new Players(ladder.getPlayers()), positionsList);
    }

    @Test
    @DisplayName("플레이어의 마지막 위치를 반환한다")
    void getLastPosition() {
        Assertions.assertThat(playerPositions.getLastPosition("test2")).isEqualTo(1);
        Assertions.assertThat(playerPositions.getLastPosition("test4")).isEqualTo(0);
    }

    @Test
    void getPlayers() {
        Assertions.assertThat(playerPositions.getPlayers()).isNotNull();
        Assertions.assertThat(playerPositions.getPlayers().size()).isEqualTo(4);
    }

    @Test
    void getPositions() {
        Assertions.assertThat(playerPositions.getPositions()).isNotNull();
        Assertions.assertThat(playerPositions.getPositions().size()).isEqualTo(4);
    }
}