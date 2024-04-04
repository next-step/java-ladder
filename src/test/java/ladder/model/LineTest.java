package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.model.Line.INVALID_LINE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("Line 객체 생성")
    void testLine_constructLine_Success() {
        Line line = Line.of(List.of(true, false));

        assertAll(
                "Assert the constructed line",
                () -> assertEquals(2, line.getSizeOfLine()),
                () -> assertTrue(line.isConnectedLadder(0)),
                () -> assertFalse(line.isConnectedLadder(1))
        );
    }

    @Test
    @DisplayName("사다리의 연달은 라인이 겹쳐서 에러 반환")
    void testLine_connectedLinesInARow_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Line.of(List.of(true, true));
        }).withMessageContaining(INVALID_LINE);
    }

    @Test
    @DisplayName("해당 index가 이전 index와 연결되어있지 않을 경우, false 반환")
    void testLine_isNotConnectedLadder_ShouldReturnFalse() {
        Line line = Line.of(List.of(true, false));

        assertThat(line.isConnectedLadder(1)).isFalse();
    }

}
