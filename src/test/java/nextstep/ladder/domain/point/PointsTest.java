package nextstep.ladder.domain.point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PointsTest {

    private Points points;

    @BeforeEach
    void setUp() {
        points = new Points(5);
    }

    @ParameterizedTest
    @DisplayName("사이즈를 초과하는 인덱스에 접근하는 경우 예외가 발생한다")
    @ValueSource(ints = {5,6,7,10})
    void throwsExceptionWhenExceedSize(int point) {
        assertThrows(IndexOutOfBoundsException.class, () -> points.connectable(point));
        assertThrows(IndexOutOfBoundsException.class, () -> points.connect(point));
        assertThrows(IndexOutOfBoundsException.class, () -> points.unUse(point));
    }

    @ParameterizedTest
    @DisplayName("Point.UNUSED는 재사용 할 수 없다")
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void connectableFalseAfterUnUsed(int point) {
        assertTrue(points.isEmpty(point));
        points.unUse(point);
        assertFalse(points.connectable(point));
    }

    @ParameterizedTest
    @DisplayName("Point.CONNECTED 는 재사용 할 수 있다")
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void connectableTrueAfterConnected(int point) {
        assertTrue(points.connectable(point));
        points.connect(point);
        assertTrue(points.connectable(point));
    }

    @ParameterizedTest
    @DisplayName("재사용 할 수 있는 포지션의 갯수는 Point.UNUSED 을 제외한 갯수이다")
    @CsvSource(value = {"0,5", "1,4", "2,3", "3,2", "4,1", "5,0"})
    void connectableCountTest(int unUsedCount, int connectableCount) {
        unUsed(unUsedCount);
        int actual = points.connectableCount();
        assertEquals(connectableCount, actual);
    }

    private void unUsed(int count) {
        for (int i = 0; i < count; i++) {
            points.unUse(i);
        }
    }


}