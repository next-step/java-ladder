package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LaddersTest {
    @DisplayName("initLadders 높이 확인")
    @Test
    void initLadders_ReturnInputHeight() {
        LadderWidth ladderWidth = new LadderWidth(4);
        LadderHeight ladderHeight = new LadderHeight(3);
        Ladders ladders = Ladders.initLadders(ladderWidth, ladderHeight, () -> Direction.RIGHT);

        assertThat(ladders.getLadderHeight()).isEqualTo(new LadderHeight(3));
    }

    @DisplayName("initLadders 가로 너비 확인")
    @Test
    void initLadders_ReturnInputWidth() {
        LadderWidth ladderWidth = new LadderWidth(4);
        LadderHeight ladderHeight = new LadderHeight(3);
        Ladders ladders = Ladders.initLadders(ladderWidth, ladderHeight, () -> Direction.RIGHT);

        assertThat(ladders.getLadderWidth()).isEqualTo(new LadderWidth(4));
    }
}