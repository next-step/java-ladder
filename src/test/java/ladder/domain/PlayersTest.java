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
}