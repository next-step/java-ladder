package ladder.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    public void 이름_제일_긴_유저_구하기() {
        Players players = new Players(Arrays.asList("hyerin", "cat"));
        int result = players.maxNameLength();
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 유저인덱스_구하기() {
        Players players = new Players(Arrays.asList("hyerin", "cat"));
        int result = players.playerIndex("hyerin");
        assertThat(result).isEqualTo(0);

        result = players.playerIndex("cat");
        assertThat(result).isEqualTo(1);
    }
}