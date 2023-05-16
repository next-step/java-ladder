package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PositionTest {

    private Position position;

    @BeforeEach
    public void setUp() {
        position = Position.firstPosition().moveNext().moveNext();
    }

    @DisplayName("포지션 이동")
    @Test
    public void movePosition() {
        assertAll(
                () -> assertThat(position.moveNext().currentPosition()).isEqualTo(3),
                () -> assertThat(position.movePrevious().currentPosition()).isEqualTo(1)
        );
    }
}
