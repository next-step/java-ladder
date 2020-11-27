package ladder.domain.ladder;

import static org.junit.jupiter.api.Assertions.assertThrows;

import ladder.exception.LadderGameException;
import org.junit.jupiter.api.Test;

class LadderHeightTest {

    @Test
    void 객체생성_실패_테스트() {
        int givenHeight = 0;
        assertThrows(LadderGameException.class, () -> new LadderHeight(givenHeight));
    }
}