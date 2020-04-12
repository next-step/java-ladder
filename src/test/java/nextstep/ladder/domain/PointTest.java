package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @DisplayName("포인트에서 다음 포인트로 이동하지 않으면 false를 반환한다")
    @Test
    void stopPoint() {
        Point point = new Point();
        assertThat(point.isNextPoint()).isFalse();
    }

    @DisplayName("포인트에서 다음 포인트로 이동할건지(선을 그으면) true를 반환한다.")
    @Test
    void movePoint() {
        Point point = new Point();
        point.drawLine();
        assertThat(point.isNextPoint()).isTrue();
    }

    @DisplayName("점의 위치가 첫번째 이고 선이 있을 경우 무조건 index 값이 +1 증가함(이동)")
    @Test
    void plusIndexForFirstPosition() {
        int index = 0;
        boolean isLine = true;
        Point point = new Point(isLine, index);
        int plusIndex = point.plusIndex();
        assertThat(plusIndex).isEqualTo(index + 1);
    }

    @DisplayName("점의 위치가 마지막이고 선이 있을 경우 무조건 index 값이 -1 증가함(이동)")
    @Test
    void minusIndexForLastPosition() {
        int index = 2;
        boolean isLine = true;
        Point point = new Point(isLine, index);
        int minusIndex = point.minusIndex();
        assertThat(minusIndex).isEqualTo(index - 1);
    }

    @DisplayName("점의 위치가 처음과 마지막이 아닐 경우는"
                 + "양옆에 왼쪽 또 오른쪽에 선이 있는는 경우에 따라 다르게 이동한다."
                 + "왼쪽으로 이동하는 경우 -1")
    @Test
    void judgeIndexForMiddlePositionAndMovingToLeft() {
        int index = 1;
        boolean isLeftLine = true;
        boolean isRightLine = false;
        Point point = new Point(isRightLine, index);
        int judgeIndex = point.judgeIndex(isLeftLine);
        assertThat(judgeIndex).isEqualTo(index - 1);

    }

    @DisplayName("점의 위치가 처음과 마지막이 아닐 경우는"
                 + "양옆에 왼쪽 또 오른쪽에 선이 있는는 경우에 따라 다르게 이동한다."
                 + "오른으로 이동하는 경우 +1")
    @Test
    void judgeIndexForMiddlePositionAndMovingToRight() {
        int index = 1;
        boolean isLeftLine = false;
        boolean isRightLine = true;
        Point point = new Point(isRightLine, index);
        int judgeIndex = point.judgeIndex(isLeftLine);
        assertThat(judgeIndex).isEqualTo(index + 1);

    }
}
