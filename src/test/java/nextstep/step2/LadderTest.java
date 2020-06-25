package nextstep.step2;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.Lines;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    void create() {
        Ladder ladder = new Ladder(6,8);
        List<Lines> newLadder = ladder.createLadder();
        assertThat(newLadder.size()).isEqualTo(8);
    }

    @Test
    void checkIfInputIsValid() {
        assertThatThrownBy(() -> new Ladder(0,0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Ladder(-1,-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
