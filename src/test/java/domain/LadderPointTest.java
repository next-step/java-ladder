package domain;

import ladder.domain.LadderDirection;
import ladder.domain.LadderPoint;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderPointTest {

    private static LadderPoint pointTest;

    @ParameterizedTest
    @DisplayName("입력받은 index가 음수 일대 에러를 던진다.")
    @ValueSource(ints = {-100, -200, -3})
    void checkIndexNegative(int index) {
        assertThatThrownBy(() ->
                pointTest = new LadderPoint(index, new LadderDirection(false, false))
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckPointIndex());
    }

    @Test
    @DisplayName("입력받은 index가 0일때 왼쪽으로 이동하면 에러를 던진다.")
    void checkMoveNegative() {
        assertThatThrownBy(() ->
                pointTest = new LadderPoint(0, new LadderDirection(true, false))
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckMoveNegative());
    }

    @Test
    @DisplayName("왼쪽으로 이동")
    void moveLeft() {
        pointTest = new LadderPoint(1, new LadderDirection(true, false));
        pointTest.move();
        assertThat(pointTest.getIndex()).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽으로 이동")
    void moveRight() {
        pointTest = new LadderPoint(1, new LadderDirection(false, true));
        pointTest.move();
        assertThat(pointTest.getIndex()).isEqualTo(2);
    }

    @Test
    @DisplayName("멈췄을 때")
    void moveStop() {
        pointTest = new LadderPoint(1, new LadderDirection(false, false));

        assertThat(pointTest.getIndex()).isEqualTo(1);
    }
}
