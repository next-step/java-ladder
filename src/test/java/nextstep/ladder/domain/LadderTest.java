package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리는_높이만큼_라인을_가진다() {
        int height = 5;
        int width = 4;
        Ladder ladder = new Ladder(height, width);

        assertEquals(height, ladder.getLines().size());
    }

    @Test
    void 높이가_0이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(0, 4));
    }

    @Test
    void 플레이어가_1명이면_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(3, 1));
    }
}

