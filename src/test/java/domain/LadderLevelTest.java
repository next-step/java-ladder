package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderLevelTest {

    @Test
    void 맞지않는_값을_입력하면_에러를_뱉는다() {
        assertThrows(IllegalArgumentException.class, () -> LadderLevel.of("이상한값"));
    }

    @Test
    void 상중하를_입력하여_난이도를_만든다() {
        LadderLevel high = LadderLevel.of("상");
        LadderLevel medium = LadderLevel.of("중");
        LadderLevel low = LadderLevel.of("하");

        assertEquals(high, LadderLevel.HIGH);
        assertEquals(medium, LadderLevel.MEDIUM);
        assertEquals(low, LadderLevel.LOW);
    }

    @Test
    void 사다리의_난이도에따라_길이가_다르다() {
        assertEquals(20, LadderLevel.HIGH.getHeight());
        assertEquals(10, LadderLevel.MEDIUM.getHeight());
        assertEquals(5, LadderLevel.LOW.getHeight());
    }

    @Test
    void 사다리의_난이도에따라_확률이_다르다() {
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            if (LadderLevel.MEDIUM.random()) {
                count++;
            }
        }

        assertTrue(count * 0.001 < 0.8);
        assertTrue(count * 0.001 > 0.3);
    }
}