package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

    @DisplayName("Players 생성 테스트")
    @Test
    void playersConstructorTest(){
        // given
        String[] playNames = {"AAA", "BBB", "CCC"};

        // when
        Players players = new Players(playNames);

        // then
        assertThat(players.getPlayers()).containsExactly(new Player("AAA"), new Player("BBB"), new Player("CCC"));
    }
}
