package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersTest {
    @Test
    void newPlayersTest() {
        assertThat(new Players("p1, p2").getCount()).isEqualTo(2);
    }
}
