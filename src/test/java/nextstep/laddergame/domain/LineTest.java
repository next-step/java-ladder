package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    void create() {
        int people = 5;
        Line line = new Line(people);
        assertThat(line).isNotNull();
    }

    @Test
    @DisplayName(value = "존재하지 않는 Index가 들어오면 RuntimeException")
    void move_hasNotPlace_RuntimeException() {
        int people = 3;
        Line line = new Line(people);
        assertThat(line).isNotNull();

        assertThatThrownBy(() -> line.moveByIndex(10))
                .isInstanceOf(RuntimeException.class);
    }
}