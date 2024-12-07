package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

class LineTest {
    @DisplayName("한 라인을 생성한다.")
    @Test
    void create() {
        Line actual = new Line(List.of(TRUE, FALSE, TRUE));

        assertThat(actual).extracting("crosses", as(LIST))
                .contains(new Cross(0, new Point(false, true)),
                        new Cross(1, new Point(true, false)),
                        new Cross(2, new Point(false, false))
                );
    }

    @DisplayName("crosses 객체의 point 상태에 따라 이동한 위치 값을 반환한다.")
    @Test
    void move() {
        Line given = new Line(List.of(TRUE, FALSE, FALSE));

        int actual = given.move(1);

        assertThat(actual).isZero();
    }
}
