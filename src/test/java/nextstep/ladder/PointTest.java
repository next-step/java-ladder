package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @Test
    @DisplayName("사다리 게임은 가로 라인이 겹치면 안된다.")
    void create() {
        assertAll(
                // 현재 값이 true 이면 다음 값은 false가 와야 한다. (true , false)
                () -> assertThat(Point.of().currentPoint()).isTrue(),
                () -> assertThat(Point.of().nextPoint()).isFalse(),
                // 현재 값이 false 이면 다음 값은 랜덤으로 false , true 다 가능하다. (false , 랜덤)
                () -> assertThat(Point.init().currentPoint()).isFalse()
        );
    }
}
