package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @Test
    @DisplayName("게임 참여자가 1명 미만 일때")
    public void createLadder() {
        Ladder ladder = Ladder.create(3, 4);
        assertThrows(IllegalArgumentException.class, () -> Ladder.create(3, -1));
    }

    @Test
    @DisplayName("사다리의 높이(깊이)가 1미만 일때")
    public void moveLadder() {
        assertThrows(IllegalArgumentException.class, () -> Ladder.create(0, 4));
    }
}


