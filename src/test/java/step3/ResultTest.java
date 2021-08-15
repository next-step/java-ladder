package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    @DisplayName("Position이 같은지 비교하는 기능의 테스트")
    void isSamePositionTest() {
        Result result = new Result("a", new Position(0));

        assertThat(result.isSamePosition(new Position(0))).isTrue();
    }
}
