package nextstep.laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import nextstep.laddergame.domain.participant.Position;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 위치는_음수가_될_수없다() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1));
    }

}