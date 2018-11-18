package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    public void 참여자생성(){
        String names = "aaa,bbb,ccc";
        Players players = Players.of(names);
        assertThat(players.getCountOfPlayer()).isEqualTo(3);
    }
}
