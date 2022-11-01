package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("가로선 전부 없음")
    void test1() {
        // given
        int countOfPerson = 5;
        Line line = new Line(countOfPerson, () -> false);
        // when
        // then
        for (int i = 1; i < countOfPerson; i++) {
            assertThat(line.isConnected(i - 1, i)).isFalse();
        }
    }

    @Test
    @DisplayName("가로선이 전부 생기게 할 경우, 중간에 한칸씩 빔")
    void test() {
        // given
        int countOfPerson = 5;
        Line line = new Line(countOfPerson, () -> true);
        // when
        // then
        for (int i = 2; i < countOfPerson; i+=2) {
            assertThat(line.isConnected(i-1, i)).isFalse();
        }
    }

    @Test
    @DisplayName("가로선 전부 없을 때, 다음 포인트 반환")
    void test2() {
        // given
        int countOfPerson = 2;
        Line line = new Line(countOfPerson, () -> false);
        // when
        int nextIndex1 = line.nextVerticalIndex(0);
        int nextIndex2 = line.nextVerticalIndex(1);
        // then
        assertThat(nextIndex1).isEqualTo(0);
        assertThat(nextIndex2).isEqualTo(1);
    }

}
