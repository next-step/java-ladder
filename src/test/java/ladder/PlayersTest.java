package ladder;

import ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @DisplayName("사람 이름은 쉼표(,)를 기준으로 구분한다.")
    @Test
    void PLAYER_DELIMITER_TEST() {
        String players = "iu,iu2,iu3,iu4";
        assertThat(new Players(players).getPlayers().size()).isEqualTo(4);
    }
}
