package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @Test
    @DisplayName("이동하지 않는 테스트")
    void justTest() {
        Position position = new Position(0);

        assertThat(position.just().equals(new Position(0))).isTrue();
    }

    @Test
    @DisplayName("왼쪽으로 이동하는 테스트")
    void toLeftTest() {
        Position position = new Position(1);

        assertThat(position.toLeft().equals(new Position(0))).isTrue();
    }

    @Test
    @DisplayName("오른쪽으로 이동하는 테스트")
    void toRightTest() {
        Position position = new Position(1);

        assertThat(position.toRight().equals(new Position(2))).isTrue();
    }
}
