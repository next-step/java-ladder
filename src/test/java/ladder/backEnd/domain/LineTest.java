package ladder.backEnd.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("모든 라인은 선(-----)을 가짐")
    void create_line() {
        Line line = new Line(5, () -> false);
    }

    @Test
    @DisplayName("모든 라인은 선(-----)을 가지지 않음")
    void all_bridge_have_no_connection() {
        Line line = new Line(5, () -> false);
    }
}
