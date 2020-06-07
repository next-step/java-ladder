package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPlayerTest {

    @Test
    void LadderCreateTest() {
        LadderPlayer pobi = LadderPlayer.create("pobi");
        assertThat(pobi.getPlayerName()).isEqualTo("pobi");
    }
}
