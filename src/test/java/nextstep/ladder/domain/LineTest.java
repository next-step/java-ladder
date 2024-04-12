package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("참가자수(n)에 따라 Line의 사이즈는 (n - 1)이 된다")
    @Test
    void initLine() {
        assertThat(new Line(3).size()).isEqualTo(2);
    }

    @DisplayName("줄(Line)의 한 점(Point)가 true인지 false인지 검증한다")
    @Test
    void name() {

    }
}
