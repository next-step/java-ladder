package ladder.domain.line;

import ladder.domain.data.LineData;
import ladder.domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LinesTest {

    @DisplayName("null 입력 예외 발생")
    @Test
    void createNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lines.create(null));
    }

    @DisplayName("lines를 수정하면 예외 발생")
    @Test
    void getLines() {
        Lines lines = Lines.create(LineData.makeRandom(2));

        assertThatThrownBy(() -> lines.getLines().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("라인의 마지막 위치 Position 반환")
    @Test
    void calculateEndPosition() {
        Lines lines = Lines.create(LineData.makeCustom(2, () -> Point.create(true)));

        assertThat(lines.calculateEndPosition(0)).isEqualTo(Position.valueOf(0));
        assertThat(lines.calculateEndPosition(1)).isEqualTo(Position.valueOf(1));
    }
}
