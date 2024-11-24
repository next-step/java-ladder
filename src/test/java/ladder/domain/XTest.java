package ladder.domain;

import ladder.exception.NotAllowedNegativeNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.exception.NotAllowedNegativeNumber.NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class XTest {


    @Test
    @DisplayName("생성 성공")
    void create() {
        X x = new X(0);
        X expected = new X();

        assertThat(x).isEqualTo(expected);
    }

    @Test
    @DisplayName("생성 실패: 음수일 수 없다.")
    void create_음수_실패() {
        assertThatThrownBy(() -> {
            X x = new X(-1);
        }).isInstanceOf(NotAllowedNegativeNumber.class)
                .hasMessage(NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE);
    }

    @Test
    @DisplayName("오른쪽으로 이동한다")
    void moveRight() {
        X x = new X();
        X actual = x.moveRight();

        X expected = new X(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽으로 이동한다")
    void moveLeft() {
        X x = new X(3);

        X actual = x.moveLeft();
        X expected = new X(2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽으로 이동 실패: 0미만")
    void moveLeft_실패_0미만() {
        Assertions.assertThatThrownBy(() -> {
            X x = new X();
            X actual = x.moveLeft();
        }).isInstanceOf(NotAllowedNegativeNumber.class)
                .hasMessage(NOT_ALLOWED_NEGATIVE_NUMBER_MESSAGE);
    }
}
