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
        assertThatNoException().isThrownBy(() -> Line.from(Collections.singletonList(Point.CONNECTED)));
        assertThatNoException().isThrownBy(() -> Line.from(Arrays.asList(Point.CONNECTED, Point.DISCONNECTED, Point.CONNECTED)));
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
        assertThatIllegalArgumentException().isThrownBy(() -> Line.from(Arrays.asList(Point.CONNECTED, Point.CONNECTED, Point.DISCONNECTED)));
    }

    @Test
    @DisplayName("주어진 포인트대로 반환")
    void points() {
        //given
        List<Point> points = Arrays.asList(Point.CONNECTED, Point.DISCONNECTED);
        //when, then
        assertThat(Line.from(points).points()).containsExactlyElementsOf(points);
    }

    @Test
    @DisplayName("사이즈 1만큼 미소유 여부")
    void hasDifferentSize() {
        //given
        Line onePointLine = Line.from(Collections.singletonList(Point.CONNECTED));
        //when, then
        assertThat(onePointLine.hasDifferentSize(1)).isFalse();
        assertThat(onePointLine.hasDifferentSize(2)).isTrue();
    }

    @Test
    @DisplayName("연결된 포인트의 움직인 인덱스의 위치는 +1")
    void movedPointIndex_connected() {
        //given
        int index = 0;
        Line twoPointsLine = Line.from(Arrays.asList(Point.CONNECTED, Point.DISCONNECTED));
        //when, then
        assertThat(twoPointsLine.movedPointIndex(index)).isEqualTo(index + 1);
    }

    @Test
    @DisplayName("연결 안된 포인트의 움직인 인덱스의 위치는 그대로")
    void movedPointIndex_disconnected() {
        //given
        int index = 1;
        Line threePointsLine = Line.from(Arrays.asList(Point.DISCONNECTED, Point.DISCONNECTED));
        //when, then
        assertThat(threePointsLine.movedPointIndex(index)).isEqualTo(index);
    }

    @Test
    @DisplayName("이전 포인트가 연결되어 있으면 인덱스의 위치는 -1")
    void movedPointIndex_previousConnected() {
        //given
        int index = 1;
        Line twoPointsLine = Line.from(Arrays.asList(Point.CONNECTED, Point.DISCONNECTED));
        //when, then
        assertThat(twoPointsLine.movedPointIndex(index)).isZero();
    }

    @Test
    @DisplayName("포인트의 인덱스를 벗어나면 안됨")
    void movedPointIndex_invalidIndex_thrown() {
        //given
        Line twoPointsLine = Line.from(Arrays.asList(Point.CONNECTED, Point.DISCONNECTED));
        //when, then
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> twoPointsLine.movedPointIndex(Integer.MAX_VALUE));
    }
}
