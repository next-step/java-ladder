package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderLineTest {
    @DisplayName("사다리 이동 테스트")
    @Test
    public void move() {
        LadderTestPointGenerator ladderPointGenerator = new LadderTestPointGenerator();
        LadderLine line = LadderLine.init(4, ladderPointGenerator);

        assertAll(
                () -> assertEquals(line.move(0), 1),
                () -> assertEquals(line.move(1), 0),
                () -> assertEquals(line.move(2), 2),
                () -> assertEquals(line.move(3), 3)
        );
    }
}