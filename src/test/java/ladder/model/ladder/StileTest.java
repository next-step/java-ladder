package ladder.model.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StileTest {
    @Test
    public void 연결여부를_확인할_수_있다() throws Exception {
        //given
        Stile left = new Stile();
        Stile right = new Stile();

        //when
        Stile.connect(left, right);

        //then
        assertFalse(left.isLeftConnected());
        assertTrue(left.isRightConnected());
        assertTrue(right.isLeftConnected());
        assertFalse(right.isRightConnected());

    }
}