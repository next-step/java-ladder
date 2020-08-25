package ladder.domain.core.line.move;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovablePoints3WayTest {
    @DisplayName("3개 라인 2개 연결 움직임 1번째 경우 테스트")
    @Test
    void moveTest_01() {
        /*
            *
            |-----|     |
            |     |-----|
         */
        final int maxPointCount = 3;
        MovablePoints line1 = MovablePoints.of(()-> true, maxPointCount);
        MovablePoints line2 = MovablePoints.ofCustomLink(maxPointCount, 1);

        assertThat(line1.move(0)).isEqualTo(1);
        assertThat(line2.move(1)).isEqualTo(2);
    }

    @DisplayName("3개 라인 2개 연결 움직임 2번째 경우 테스트")
    @Test
    void moveTest_02() {
        /*
                  *
            |-----|     |
            |     |-----|
         */
        final int maxPointCount = 3;
        MovablePoints line1 = MovablePoints.of(()-> true, maxPointCount);
        MovablePoints line2 = MovablePoints.ofCustomLink(maxPointCount, 1);

        assertThat(line1.move(1)).isEqualTo(0);
        assertThat(line2.move(0)).isEqualTo(0);
    }

    @DisplayName("3개 라인 2개 연결 움직임 3번째 경우 테스트")
    @Test
    void moveTest_03() {
        /*
                        *
            |-----|     |
            |     |-----|
         */
        final int maxPointCount = 3;
        MovablePoints line1 = MovablePoints.of(()-> true, maxPointCount);
        MovablePoints line2 = MovablePoints.ofCustomLink(maxPointCount, 1);

        assertThat(line1.move(2)).isEqualTo(2);
        assertThat(line2.move(2)).isEqualTo(1);
    }

    @DisplayName("3개 라인 3개 연결 움직임 1번째 경우 테스트")
    @Test
    void moveTest_04() {
        /*
            *
            |-----|     |
            |     |-----|
            |-----|     |
         */
        final int maxPointCount = 3;
        List<MovablePoints> lines = MovableLineTestData.pointsType01(maxPointCount);
        List<Integer> result = MovableLine.findByMovingPointToStartIndex(lines, 0);
        assertThat(result).containsExactly(1,2,2);
    }

    @DisplayName("3개 라인 3개 연결 움직임 2번째 경우 테스트")
    @Test
    void moveTest_05() {
        /*
                  *
            |-----|     |
            |     |-----|
            |-----|     |
         */
        final int maxPointCount = 3;
        List<MovablePoints> lines = MovableLineTestData.pointsType01(maxPointCount);
        List<Integer> result = MovableLine.findByMovingPointToStartIndex(lines, 1);
        assertThat(result).containsExactly(0,0,1);
    }

    @DisplayName("3개 라인 3개 연결 움직임 3번째 경우 테스트")
    @Test
    void moveTest_06() {
        /*
                        *
            |-----|     |
            |     |-----|
            |-----|     |
         */
        final int maxPointCount = 3;
        List<MovablePoints> lines = MovableLineTestData.pointsType01(maxPointCount);
        List<Integer> result = MovableLine.findByMovingPointToStartIndex(lines, 2);
        assertThat(result).containsExactly(2, 1, 0);
    }

}