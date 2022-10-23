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

}
