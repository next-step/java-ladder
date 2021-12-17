package ladder;

import ladder.domain.Player;
import ladder.domain.Players;
import ladder.exception.PlayerException;
import ladder.view.ResultView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    @DisplayName("플레이어들 생성")
    void createPlayers() {
        Players players = Players.of("p1, p2, p3, p4, p5");
        Assertions.assertThat(players.count()).isEqualTo(5);
        ResultView.printPlayers(players);
    }

    @Test
    @DisplayName("플레이어 이름은 5자 이하")
    void validPlayer() {
        Assertions.assertThatThrownBy(() -> new Player("다섯글자이상")).isInstanceOf(PlayerException.class);
    }
}
