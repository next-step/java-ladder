package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {
    @Test
    @DisplayName("생성 / 라인이 겹치게 생성 / IllegalArgumentException")
    void createOverlapLineFail() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Line(Arrays.asList(TRUE, TRUE, FALSE)));
    }

    @Test
    @DisplayName("이동 / / 성공")
    void move() {
        /*
        0     1     2     3     4     5
        |     |-----|     |     |-----|
         */
        Line line = new Line(Arrays.asList(FALSE, TRUE, FALSE, FALSE, TRUE));

        assertThat(line.move(0)).isEqualTo(0);
        assertThat(line.move(1)).isEqualTo(2);
        assertThat(line.move(2)).isEqualTo(1);
        assertThat(line.move(3)).isEqualTo(3);
        assertThat(line.move(4)).isEqualTo(5);
        assertThat(line.move(5)).isEqualTo(4);
    }
}