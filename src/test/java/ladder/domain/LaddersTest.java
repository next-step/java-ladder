package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LaddersTest {
    @DisplayName("initLadders 높이, 길이 확인")
    @Test
    void initLadders() {
        LadderWidth ladderWidth = new LadderWidth(4);
        LadderHeight ladderHeight = new LadderHeight(3);
        Ladders ladders = Ladders.initLadders(ladderWidth, ladderHeight, () -> Direction.RIGHT);
        List<Line> lines = ladders.getLines();
        assertThat(lines.size()).isEqualTo(3);

        Line firstLine = lines.get(0);
        assertThat(firstLine.getDirections().size()).isEqualTo(4);
    }
}