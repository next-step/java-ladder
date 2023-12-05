package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LadderTest {

    private static List<HorizontalLine> newHorizontalLines() {
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        horizontalLines.add(new HorizontalLine(true, false, true, false));
        horizontalLines.add(new HorizontalLine(false, true, false, true));
        return horizontalLines;
    }

    @Test
    void 플레이어_한_명이_사다리_탄_결과() {
        Ladder ladder = new Ladder(newHorizontalLines());
        int playerStartPosition = 0;
        assertThat(ladder.climb(playerStartPosition)).isEqualTo(2);
    }
}
