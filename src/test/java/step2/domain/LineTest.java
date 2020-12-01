package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(line.getDirections()).containsExactly(Way.DOWN, Way.DOWN, Way.DOWN, Way.DOWN);
    }

}