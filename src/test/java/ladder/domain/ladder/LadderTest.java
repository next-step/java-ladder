package ladder.domain.ladder;

import ladder.domain.line.Line;
import ladder.domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 생성 확인")
    void construct() {
        //given
        Ladder ladder = Ladder.of("pro,semi,ama", 3);

        //when
        List<Player> players = ladder.getPlayers();
        List<Line> lines = ladder.getLines();

        //then
        assertThat(players).hasSize(3);
        assertThat(lines).hasSize(3);

    }
}
