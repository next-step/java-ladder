package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("사다리의 한 라인을 입력한다.")
    void input_line_test() {
        List<Boolean> points = Arrays.asList(false, true, false);

        Line line = new Line(points);

        assertThat(line.getPoints().size()).isEqualTo(points.size());
    }

    @Test
    @DisplayName("라인이 빈값일 경우 예외가 발생한다.")
    void input_line_exception_test() {
        assertThatThrownBy(() ->
                new Line(Collections.emptyList())
        ).isInstanceOf(IllegalArgumentException.class);
    }
}