package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인 생성 테스트")
    void line_creation(){
        Line line = Line.of(6, (num)->true);
        assertThat(line.getPointList()).containsExactly(
                true, false, true, false, true, false
        );
    }

    @Test
    @DisplayName("라인 생성 테스트2")
    void line_creation2(){
        Line line = Line.of(5, (num)-> num % 2 == 0);
        assertThat(line.getPointList()).containsExactly(
                false, true, false, true, false
        );
    }
}