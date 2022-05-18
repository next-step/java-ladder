package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    Point pointForFirstLine;

    @BeforeEach
    void setUp() {
        pointForFirstLine = Point.createPointForFirstLine(() -> true);
    }

    @Test
    @DisplayName("첫번째 줄에 들어가는 point 는 왼쪽으로 이동 불가")
    void createForFirstLineTest() {
        assertThat(pointForFirstLine.isLeft()).isFalse();
    }

    @Test
    @DisplayName("마지막 줄에 들어가는 point 는 오른쪽으로 이동 불가")
    void createForLastLineTest() {
        Point pointForLastLine = Point.createPointForLastLine(pointForFirstLine);
        assertThat(pointForLastLine.isRight()).isFalse();
    }

    @Test
    @DisplayName("이전 point 가 왼쪽방향 갖고 있으면 현재 point 는 오른쪽 방향 갖음")
    void createForMidLineTest() {
        Point pointForMiddleLine = Point.createPointForMiddleLine(pointForFirstLine, () -> true);
        assertThat(pointForMiddleLine.isLeft()).isTrue();
    }

    @Test
    @DisplayName("이전 point 가 왼쪽방향 갖고 있지 않으면 현재 point 는 오른쪽 방향 갖지 않음")
    void createForMidLineTest_isNotLeft() {
        Point pointForMiddleLine = Point.createPointForMiddleLine(pointForFirstLine, () -> false);
        assertThat(pointForMiddleLine.isRight()).isFalse();
    }


}