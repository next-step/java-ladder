package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("라인이 잘 생성 되는지 확인한다.")
    void create() {
        Line line = Line.of(4, new MustLineStrategy());
        assertThat(line).isEqualTo(Line.of(4, new MustLineStrategy()));
    }

    @Test
    @DisplayName("라인이 Point가 잘 생성되는지 본다.")
    void getLine() {
        Line line = Line.of(4, new MustLineStrategy());
        assertThat(line.getPoints()).containsExactly(true, false, true, false);
    }

}