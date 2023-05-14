package nextstep.laddergame.vo;

import nextstep.laddergame.domain.ladder.Line;
import nextstep.laddergame.domain.ladder.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


public class DirectionTypeTest {
    @Test
    @DisplayName("방향 확인 테스트")
    void checkDirectionType() {
        final Lines lines = new Lines(List.of(new Line(List.of(false, true, false, false))));

        assertAll(
                () -> assertThat(DirectionType.checkDirection(1, 0, lines))
                        .isEqualTo(DirectionType.LEFT),
                () -> assertThat(DirectionType.checkDirection(0, 0, lines))
                        .isEqualTo(DirectionType.RIGHT),
                () -> assertThat(DirectionType.checkDirection(2, 0, lines))
                        .isEqualTo(DirectionType.DOWN)
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
                () -> assertThat(DirectionType.DOWN.moveRow())
                        .isEqualTo(0)
        );
    }
}
