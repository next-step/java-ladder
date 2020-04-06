package Ladder;

import Ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    @Test
    @DisplayName("사용자는 반드시 2명 이상 되어야한다")
    void errorOnPlayersMinimumCount() {
        final String[] nameArr = {"jin"};

        assertThatThrownBy(() -> new Players(nameArr)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 잘 만들어지는지 테스트 한다")
    void playerCountTest() {
        final String[] nameArr = {"jin", "woo", "miny"};

        assertThat(new Players(nameArr).getPlayersNumber()).isEqualTo(3);
    }
}
