package ladder.model;

import ladder.util.MockLadderGenerator;
import ladder.util.MockPlayersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("ride 메소드 테스트")
    void ride() {
        Players players = MockPlayersGenerator.of("lee", "kim", "soo");
        Ladder ladder = MockLadderGenerator.makeLadder();

        List<Player> playerList = players.getPlayers();
        Player secondPlayer = playerList.get(1);

        assertThat(secondPlayer.getName()).isEqualTo("kim");
        assertThat(secondPlayer.getPosition()).isEqualTo(new Position(1));

        ladder.ride(players);

        assertThat(secondPlayer.getPosition()).isEqualTo(new Position(3));
    }
}
