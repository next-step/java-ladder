package ladder.domain;

import ladder.enums.LadderPart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LineTest {

    @DisplayName("width 홀수로 Line 생성. LadderPart로 구성")
    @Test
    void create() {
        int width = 5;
        Line line = new Line(width);

        assertThat(line.width()).isEqualTo(width);
    }

    @DisplayName("width는 짝수 안됨.")
    @Test
    void create_even() {
        assertThatThrownBy(() -> new Line(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("width는 짝수일 수 없습니다.");
    }

    @DisplayName("올바른 ladderParts 구성")
    @Test
    void create_ladderParts() {
        assertDoesNotThrow(() -> new Line(Arrays.asList(LadderPart.RAIL, LadderPart.RUNG, LadderPart.RAIL)));
    }

    @DisplayName("틀린 ladderParts 구성. 짝수는 RAIL")
    @Test
    void create_ladderParts_rail() {
        assertThatThrownBy(() -> new Line(Arrays.asList(LadderPart.RUNG, LadderPart.RUNG, LadderPart.RAIL)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Line.INVALID_PART_EVEN_RAIL_MESSAGE);
    }

    @DisplayName("틀린 ladderParts 구성. 홀수는 RUNG")
    @Test
    void create_ladderParts_rung() {
        assertThatThrownBy(() -> new Line(Arrays.asList(LadderPart.RAIL, LadderPart.RAIL, LadderPart.RAIL)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Line.INVALID_PART_ODD_RUNG_MESSAGE);
    }
}
