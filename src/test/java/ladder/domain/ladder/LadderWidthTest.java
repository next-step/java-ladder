package ladder.domain.ladder;

import ladder.exception.ladder.LadderWidthBoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderWidthTest {

    @Test
    void create() {
        LadderWidth ladderWidth = new LadderWidth(3);

        assertThat(ladderWidth).isEqualTo(new LadderWidth(3));
    }

    @Test
    void valid_more_2() {
        assertThatThrownBy(() -> new LadderWidth(1)).isInstanceOf(LadderWidthBoundException.class);
    }
}
