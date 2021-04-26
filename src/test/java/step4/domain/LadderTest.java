package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @DisplayName("사다리의 결과 테스트")
    @Test
    void ladderEndResultTest() {
        Ladder ladder = Ladder.of(5, 4, new LadderTestPointGenerator());
        
        Assertions.assertAll(
                () -> assertEquals(ladder.getLadderEndResult(new Position(0)), new Position(1)),
                () -> assertEquals(ladder.getLadderEndResult(new Position(1)), new Position(0)),
                () -> assertEquals(ladder.getLadderEndResult(new Position(2)), new Position(2)),
                () -> assertEquals(ladder.getLadderEndResult(new Position(3)), new Position(3))
        );

    }
}
