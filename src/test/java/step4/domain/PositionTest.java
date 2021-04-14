package step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import step4.exception.NaturalNumberException;

public class PositionTest {
    @Test
    void 생성_테스트() {
        Position position = Position.valueOf(0);
        assertThat(position).isEqualTo(Position.valueOf(0));
    }

    @Test
    void 유효성_테스트() {
        Assertions.assertThrows(NaturalNumberException.class, () -> Position.valueOf(-1));
    }
}
