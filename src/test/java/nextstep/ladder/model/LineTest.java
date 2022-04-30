package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("라인")
class LineTest {

    @Test
    @DisplayName("포인트들로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Line.from(Collections.singletonList(Point.connected())));
        assertThatNoException().isThrownBy(() -> Line.from(Arrays.asList(Point.connected(), Point.disconnected(), Point.connected())));
    }

    @Test
    @DisplayName("포인트들은 필수")
    void instance_nullOrEmpty_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.from(null));
        assertThatIllegalArgumentException().isThrownBy(() -> Line.from(Collections.emptyList()));
    }

    @Test
    @DisplayName("연결된 포인트들이 연속적으로 존재할 수 없음")
    void instance_continuouslyConnected_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.from(Arrays.asList(Point.disconnected(), Point.connected(), Point.connected())));
    }

    @Test
    @DisplayName("주어진 포인트대로 반환")
    void points() {
        //given
        List<Point> points = Arrays.asList(Point.connected(), Point.disconnected());
        //when, then
        assertThat(Line.from(points).points()).containsExactlyElementsOf(points);
    }

    @Test
    @DisplayName("사이즈 1만큼 미소유 여부")
    void hasDifferentSize() {
        //given
        Line onePointLine = Line.from(Collections.singletonList(Point.connected()));
        //when, then
        assertThat(onePointLine.hasDifferentSize(1)).isFalse();
        assertThat(onePointLine.hasDifferentSize(2)).isTrue();
    }
}
