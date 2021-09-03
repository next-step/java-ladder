package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {

    @Test
    @DisplayName("LadderResult의 get은 index를 입력받고 해당 index의 결과를 가져온다.")
    void get(){
        String[] result = {"1000", "꽝"};
        LadderResult ladderResult = new LadderResult(result);

        assertAll(
                () -> assertEquals(result[0], ladderResult.get(0)),
                () -> assertEquals(result[1], ladderResult.get(1))
        );
    }
}