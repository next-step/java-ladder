package ladder.domain;

import ladder.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTest {

    @Test
    @DisplayName("다음 방향 테스트")
    void nextTest(){
        assertAll(
                () -> assertThat(Direction.RIGHT.nextIndex(1)).isEqualTo(2),
                () -> assertThat(Direction.LEFT.nextIndex(2)).isEqualTo(1),
                () -> assertThat(Direction.NONE.nextIndex(3)).isEqualTo(3)
        );
    }
}
