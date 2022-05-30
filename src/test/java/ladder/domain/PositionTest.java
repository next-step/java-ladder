package ladder.domain;

import ladder.constant.Direction;
import ladder.constant.Type;
import ladder.exception.NotChangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    public static final Position FIXED_1000_ZERO_INDEX = new Position(IndexTest.ZERO_INDEX, NameTest.NAME_1000, Type.FIXED);
    public static final Position FIXED_FAIL_ONE_INDEX = new Position(IndexTest.ONE_INDEX, NameTest.NAME_FAIL, Type.FIXED);

    @Test
    @DisplayName("포지션 타입이 FIXED 일때 변경하면 예외를 반환한다.")
    void invalidChange() {
        Position position = new Position(2, 1, "꽝",  Type.FIXED);

        assertThatThrownBy(() -> position.change(Direction.RIGHT))
                .isInstanceOf(NotChangeException.class)
                .hasMessage("고정된 Position 이여서 변경할 수 없습니다.");
        assertThatThrownBy(() -> position.change(Direction.LEFT))
                .isInstanceOf(NotChangeException.class)
                .hasMessage("고정된 Position 이여서 변경할 수 없습니다.");
    }
}