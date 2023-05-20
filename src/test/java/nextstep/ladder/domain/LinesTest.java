package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LinesTest {

    @Test
    void 일급_컬렉션은_기본으로_unmodifiable_적용() {
        //given
        Line line = new Line(3);
        Lines lines = new Lines(Arrays.asList(line, line));

        //when
        //then
        assertThatThrownBy(() -> lines.value().add(line))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
