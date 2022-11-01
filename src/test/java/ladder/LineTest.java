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
        Line line = new Line(countOfPerson, (left) -> false);
        // when
        // then
        for (int i = 1; i < countOfPerson; i++) {
            assertThat(line.isConnected(i - 1, i)).isFalse();
        }
    }

    @Test
    @DisplayName("가로선 전부 없을 때, 다음 포인트 반환")
    void test2() {
        // given
        int countOfPerson = 2;
        Line line = new Line(countOfPerson, (left) -> false);
        // when
        int nextIndex1 = line.nextVerticalIndex(0);
        int nextIndex2 = line.nextVerticalIndex(1);
        // then
        assertThat(nextIndex1).isEqualTo(0);
        assertThat(nextIndex2).isEqualTo(1);
    }

    @Test
    @DisplayName("가로선이 홀수에만 나타남")
    void test3() {
        // given
        int countOfPerson = 6;
        // when
        Line line = new Line(countOfPerson, (left) -> left % 2 == 0);
        // then
        for (int left = 0; left < countOfPerson; left += 2) {
            int right = left + 1;
            assertThat(line.isConnected(left, right)).isTrue();
        }
        for (int left = 1; left < countOfPerson; left += 2) {
            int right = left + 1;
            assertThat(line.isConnected(left, right)).isFalse();
        }
    }

    @Test
    @DisplayName("가로선이 짝수에만 나타남")
    void test4() {
        // given
        int countOfPerson = 6;
        // when
        Line line = new Line(countOfPerson, (left) -> left % 2 == 1);
        // then
        for (int left = 0; left < countOfPerson; left += 2) {
            int right = left + 1;
            assertThat(line.isConnected(left, right)).isFalse();
        }
        for (int left = 1; left < countOfPerson - 1; left += 2) {
            int right = left + 1;
            assertThat(line.isConnected(left, right)).isTrue();
        }
    }

}
