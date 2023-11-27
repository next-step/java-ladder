package ladder_v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    @DisplayName("Position은 0보다 작을 수 없다")
    void positionInput(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position(-1);
        });
    }

    @Test
    @DisplayName("Position을 특정 Direction으로 움직이면 Position이 반환된다.")
    void positionMove(){
        Position position = new Position(0);
        assertThat(position.move(Direction.RIGHT)).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("Position은 position을 반환할 수 있다.")
    void positionReturn(){
        Position position = new Position(0);
        assertThat(position.position()).isEqualTo(0);
    }
}
