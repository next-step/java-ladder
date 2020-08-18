package ladder.domain.core.line;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovableLine2WayTest {
    @DisplayName("2개 라인 1개 연결 움직임 테스트")
    @Test
    void moveTest_01() {
        /*
                  *
            |-----|
            |     |
         */
        final int maxPointCount = 2;
        MovableLine line1 = MovableLine.create(()-> true, maxPointCount);
        MovableLine line2 = MovableLine.create(()-> false, maxPointCount);

        assertThat(line1.move(1)).isEqualTo(0);
        assertThat(line2.move(0)).isEqualTo(0);
    }

    @DisplayName("2개 라인 연결 움직임 테스트")
    @Test
    void move2Test() {
        /*
                  *
            |-----|
            |-----|
         */
        final int maxPointCount = 2;
        MovableLine line1 = MovableLine.create(()-> true, maxPointCount);
        MovableLine line2 = MovableLine.create(()-> true, maxPointCount);

        assertThat(line1.move(1)).isEqualTo(0);
        assertThat(line2.move(0)).isEqualTo(1);
    }

    @DisplayName("3개 라인 2개 연결 움직임 테스트")
    @Test
    void move3Test() {
        /*
                  *
            |-----|
            |     |
            |-----|
         */
        final int maxPointCount = 2;
        List<MovableLine> lines = Arrays.asList(
            MovableLine.create(()-> true, maxPointCount),
            MovableLine.create(()-> false, maxPointCount),
            MovableLine.create(()-> true, maxPointCount)
        ) ;
        List<Integer> result = MovableLines.getLinePathResult(lines, 1);
        assertThat(result).containsExactly(0,0,1);
    }

    @DisplayName("3개 라인 3개 연결 움직임 테스트")
    @Test
    void move4Test() {
        /*
                  *
            |-----|
            |-----|
            |-----|
         */
        final int maxPointCount = 2;

        List<MovableLine> lines = Arrays.asList(
            MovableLine.create(()-> true, maxPointCount),
            MovableLine.create(()-> true, maxPointCount),
            MovableLine.create(()-> true, maxPointCount)
        ) ;
        List<Integer> result = MovableLines.getLinePathResult(lines, 1);
        assertThat(result).containsExactly(0,1,0);
    }



}