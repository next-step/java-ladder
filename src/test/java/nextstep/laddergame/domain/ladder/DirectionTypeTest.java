package nextstep.laddergame.domain.ladder;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionTypeTest {
    @Test
    @DisplayName("방향 확인 테스트")
    void checkDirectionType() {
        assertAll(
                () -> assertThat(DirectionType.checkDirection(true, false))
                        .isEqualTo(DirectionType.LEFT),
                () -> assertThat(DirectionType.checkDirection(false, true))
                        .isEqualTo(DirectionType.RIGHT),
                () -> assertThat(DirectionType.checkDirection(false, false))
                        .isEqualTo(DirectionType.PASS),
                () -> assertThatThrownBy(() -> DirectionType.checkDirection(true, true))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("방향에 따른 좌표 값 변화 테스트")
    void moveRow() {
        assertAll(
                () -> assertThat(DirectionType.LEFT.moveRow())
                        .isEqualTo(-1),
                () -> assertThat(DirectionType.RIGHT.moveRow())
                        .isEqualTo(1),
                () -> assertThat(DirectionType.PASS.moveRow())
                        .isEqualTo(0)
        );
    }
}
