package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("연속된 true가 없는 경우 Line 생성")
    void createLineWithoutConsecutiveTrues() {
        List<Boolean> points = Arrays.asList(true, false, true, false);
        Line line = new Line(points);

        assertEquals(points.size(), line.size());
        for (int i = 0; i < points.size(); i++) {
            assertEquals(points.get(i), line.isPointTrue(i));
        }
    }

    @Test
    @DisplayName("연속된 true가 있는 경우 예외 발생")
    void createLineWithConsecutiveTruesThrowsException() {
        List<Boolean> points = Arrays.asList(true, true, false, true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Line(points));
        assertEquals("Consecutive true points are not allowed", exception.getMessage());
    }

    @Test
    @DisplayName("Line의 크기 확인")
    void lineSize() {
        List<Boolean> points = Arrays.asList(false, true, false);
        Line line = new Line(points);

        assertEquals(3, line.size());
    }

    @Test
    @DisplayName("지정된 인덱스의 값 확인 - true인 경우")
    void isPointTrueAtTruePosition() {
        List<Boolean> points = Arrays.asList(false, true, false);
        Line line = new Line(points);

        assertTrue(line.isPointTrue(1));
    }

    @Test
    @DisplayName("지정된 인덱스의 값 확인 - false인 경우")
    void isPointTrueAtFalsePosition() {
        List<Boolean> points = Arrays.asList(false, true, false);
        Line line = new Line(points);

        assertFalse(line.isPointTrue(0));
        assertFalse(line.isPointTrue(2));
    }

    @Test
    @DisplayName("동일한 points 리스트를 가진 Line 객체 equals 비교")
    void lineEqualsWithSamePoints() {
        List<Boolean> points1 = Arrays.asList(false, true, false);
        Line line1 = new Line(points1);
        Line line2 = new Line(points1);

        assertEquals(line1, line2);
    }

    @Test
    @DisplayName("서로 다른 points 리스트를 가진 Line 객체 equals 비교")
    void lineNotEqualsWithDifferentPoints() {
        Line line1 = new Line(Arrays.asList(false, true, false));
        Line line2 = new Line(Arrays.asList(true, false, true));

        assertNotEquals(line1, line2);
    }

    @Test
    @DisplayName("null 객체와 equals 비교")
    void lineNotEqualsWithNull() {
        Line line = new Line(Arrays.asList(false, true, false));

        assertNotEquals(line, null);
    }

    @Test
    @DisplayName("다른 클래스 객체와 equals 비교")
    void lineNotEqualsWithDifferentClass() {
        Line line = new Line(Arrays.asList(false, true, false));

        assertNotEquals(line, "someString");
    }

    @Test
    @DisplayName("자기 자신과 equals 비교")
    void lineEqualsWithSelf() {
        Line line = new Line(Arrays.asList(false, true, false));

        assertEquals(line, line);
    }
}
