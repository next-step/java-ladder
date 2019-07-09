package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DirectionsTest {
    @Test
    @DisplayName("첫번째 Point 의 Directions 생성, 왼쪽은 사다리가 생성될 수 없다.")
    void create_first() {
        Directions directions = Directions.createFirst(() -> true);

        assertAll(
            () -> assertThat(directions).isEqualTo(Directions.createFirst(() -> true)),
            () -> assertThat(directions.isLeftLine()).isFalse(),
            () -> assertThat(directions.isRightLine()).isTrue()
        );
    }

    @Test
    @DisplayName("다음 Point 의 Directions 생성, 직전 Point 의 right 에 따라 left 가 지정된다.")
    void create_next() {
        Directions directions = Directions.createNext(() -> true, false);
        Directions directions2 = Directions.createNext(() -> true, true);
        assertAll(
            () -> assertThat(directions.isLeftLine()).isFalse(),
            () -> assertThat(directions.isRightLine()).isTrue(),
            () -> assertThat(directions2.isRightLine()).isFalse()
        );
    }

    @Test
    @DisplayName("마지막 Point 의 Directions 생성, 오른쪽은 사다리가 생성될 수 없다.")
    void create_last() {
        Directions directions = Directions.createLast(true);
        assertAll(
            () -> assertThat(directions.isLeftLine()).isTrue(),
            () -> assertThat(directions.isRightLine()).isFalse()
        );
    }

}
