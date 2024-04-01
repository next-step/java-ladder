package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("해당 index가 이전 index와 연결되어있을 경우, true 반환")
    void testLine_isConnectedLadder_ShouldReturnTrue() {
        Line line = new Line(List.of(true, true));

        assertThat(line.isConnectedLadder(1)).isTrue();
    }

    @Test
    @DisplayName("해당 index가 이전 index와 연결되어있지 않을 경우, false 반환")
    void testLine_isNotConnectedLadder_ShouldReturnFalse() {
        Line line = new Line(List.of(true, false));

        assertThat(line.isConnectedLadder(1)).isFalse();
    }

}
