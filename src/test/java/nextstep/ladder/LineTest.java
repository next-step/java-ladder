package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import nextstep.ladder.domain.ladder.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("가로라인이 겹치면 IllegalArgumentException이 발생한다.")
    void DUPLICATE_LINE_THEN_EXCEPTION() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(true, true));
    }

    @Test
    @DisplayName("가로라인이 겹치않으면 Exception이 발생하지 않는다.")
    void NO_DUPLICATE_LINE_THEN_NOTHING() {
        assertThatNoException().isThrownBy(() -> Line.of(true, false));
    }

    @Test
    @DisplayName("입력된 위치가 왼쪽과 연결되어 있으면 좌로 한칸 이동한다.")
    void MOVE_LEFT_IF_LEFT_POINT_CONNECTED() {
        Line line = Line.of(true, false, true);
        Assertions.assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("입력된 위치가 왼쪽과 연결되어 있으면 좌로 한칸 이동한다.")
    void MOVE_RIGHT_IF_RIGHT_POINT_CONNECTED() {
        Line line = Line.of(false, true, false);
        Assertions.assertThat(line.move(2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("양 POINT가 연결되어 있지 않다면 움직이지 않는다.")
    void NO_MOVE_IF_BOTH_POINT_NOT_CONNECTED() {
        Line line = Line.of(false, false, false);
        Assertions.assertThat(line.move(1)).isEqualTo(0);
    }
}
