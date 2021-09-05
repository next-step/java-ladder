package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        Position position = new Position(0, 5);
        assertThat(position.toString()).isEqualTo("0");
    }

    @Test
    @DisplayName("MAX_POSITION 넘어가는 position 값으로 생성 불가능.")
    void throwInputError() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Position(10, 5)
        ).withMessageContaining("위치");
    }

    @Test
    @DisplayName("포지션 이동하기 (같은 수 입력시 1 증가)")
    void moveRightTest() {
        Position position = new Position(0, 5);
        position.move(0);
        assertThat(position.toString()).isEqualTo("1");
    }

    @Test
    @DisplayName("포지션 이동하기 (1 작은수 입력시 이동)")
    void moveLeftTest() {
        Position position = new Position(1, 5);
        position.move(0);
        assertThat(position.toString()).isEqualTo("0");
    }
}