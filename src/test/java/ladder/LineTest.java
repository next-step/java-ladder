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
        Line line = new Line(countOfPerson, (left, right, points) -> false);
        // when
        // then
        for (int i = 1; i < countOfPerson; i++) {
            assertThat(line.isConnected(i - 1, i)).isFalse();
        }
    }

    @Test
    @DisplayName("가로선 전부 있음")
    void test2() {
        // given
        int countOfPerson = 5;
        Line line = new Line(countOfPerson, (left, right, points) -> true);
        // when
        // then
        for (int i = 1; i < countOfPerson; i++) {
            assertThat(line.isConnected(i - 1, i)).isTrue();
        }
    }

}
