package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 입력된_숫자_만큼_라인이_생성_된다() {
        Line actual = new Line(2);
        Line expected = new Line(List.of(Boolean.TRUE, Boolean.TRUE));

        assertThat(actual).isEqualTo(expected);
    }
}
