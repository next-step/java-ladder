package nextstep.ladder2.ladder;

import nextstep.ladder2.domain.ladder.Direction;
import nextstep.ladder2.domain.ladder.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @ParameterizedTest
    @ValueSource(ints={-1, -2})
    public void 포지션값은_0보다같거나커야한다(int value) {
        assertThatThrownBy(() -> {
            Position.of(value, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void 포지션값은_최대값보다_작아야한다() {
        assertThatThrownBy(() -> {
            Position.of(5, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 왼쪽으로이동하면_위치값이_1작아진다() {
        Position position = Position.of(3, 5);

        position.moveBy(Direction.LEFT);

        assertThat(position.value()).isEqualTo(2);
    }

    @Test
    public void 오른쪽으로이동하면_위치값이_1커진다() {
        Position position = Position.of(3, 5);

        position.moveBy(Direction.RIGHT);

        assertThat(position.value()).isEqualTo(4);
    }
    
    @Test
    public void 범위를_벗어나는_이동은_예외가_발생한다() {
        Position position = Position.of(0, 5);
        
        assertThatThrownBy(() -> {
            position.moveBy(Direction.LEFT);
        }).isInstanceOf(IllegalArgumentException.class);
        
        Position position2 = Position.of(4, 5);
        
        assertThatThrownBy(() -> {
            position2.moveBy(Direction.RIGHT);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
