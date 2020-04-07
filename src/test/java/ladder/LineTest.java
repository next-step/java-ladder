package ladder;

import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    @DisplayName("연결되어 있는 Point 가 2개 이상 올 수 없다")
    public void initExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(Point.CONNECTED, Point.CONNECTED, Point.UNCONNECTED));
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(Point.UNCONNECTED, Point.CONNECTED, Point.CONNECTED));
    }

}
