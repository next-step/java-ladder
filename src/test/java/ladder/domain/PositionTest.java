package ladder.domain;

import ladder.domain.position.Position;
import ladder.exception.InvalidPositionException;
import ladder.helper.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @DisplayName("사다리 상의 x, y 좌표와 LadderSize 인스턴스를 받아 생성된다.")
    @Test
    void create() {
        assertThat(new Position(0, Fixture.ladderSize()));
    }

    @DisplayName("Position이 LadderSize의 최대 가로 세로 좌표 값을 넘어가면 Exception 발생")
    @Test
    void validate() {
        assertThatThrownBy(() -> new Position(-1, Fixture.ladderSize())).isInstanceOf(InvalidPositionException.class);
        assertThat(new Position(0, Fixture.ladderSize()));
    }
}
