package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPointTest {
    @DisplayName("move Test")
    @Test
    void move() {
        LadderLine ladderLine = LadderLine.of(
                Stream.of(false, true, false, false, false)
                .map(Rope::new)
                .collect(Collectors.toList())
        );
        assertThat(new LadderPoint(0).move(ladderLine))
                .isEqualTo(new LadderPoint(1, 1));
        assertThat(new LadderPoint(1).move(ladderLine))
                .isEqualTo(new LadderPoint(0, 1));
        LadderPoint p = new LadderPoint(2).move(ladderLine);
        assertThat(new LadderPoint(2).move(ladderLine))
                .isEqualTo(new LadderPoint(2, 1));
    }
}