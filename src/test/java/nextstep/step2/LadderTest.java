package nextstep.step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        Ladder ladder = new Ladder(6,8);
        List<Lines> newLadder = ladder.createLadder();
        assertThat(newLadder.size()).isEqualTo(8);
    }
}
