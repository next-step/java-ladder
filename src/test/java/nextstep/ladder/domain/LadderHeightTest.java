package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderHeightTest {
    @Test
    @DisplayName("성공 - getValue메서드가 value를 반환한다.")
    void initLadderTest() {
        LadderHeight height = new LadderHeight(1);
        assertThat(height.getValue()).isEqualTo(1);
    }

    @Test
    @DisplayName("성공 - LadderHeight 객체가 동등성을 보장한다.")
    void equalsTest() {
        LadderHeight height1 = new LadderHeight(1);
        LadderHeight height2 = new LadderHeight(1);
        assertThat(height1).isEqualTo(height2);
    }
}