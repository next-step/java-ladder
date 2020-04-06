package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @DisplayName("여러명의 참여자를 생성한다.")
    @Test
    void create() {
        List<Player> playerList = Arrays.asList(new Player("pobi"), new Player("honux"));
        Players expect = new Players(playerList);

        Players actual = new Players(playerList);

        assertThat(actual).isEqualTo(expect);
        assertThat(actual.count()).isEqualTo(2);
    }

}