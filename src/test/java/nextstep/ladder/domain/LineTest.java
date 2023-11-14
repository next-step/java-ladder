package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 입력된_숫자_만큼_라인이_생성_된다() {
        Line actual = new Line(List.of(Boolean.TRUE, Boolean.TRUE));
        Line expected = new Line(List.of(Boolean.TRUE, Boolean.TRUE));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이전_위치에_가로선이_있을_경우_그릴_수_없다() {
        Line line = new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
        boolean actual = line.canDraw(1);

        assertThat(actual).isFalse();
    }

    @Test
    void 다음_위치에_가로선이_있을_경우_그릴_수_없다() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));
        boolean actual = line.canDraw(1);

        assertThat(actual).isFalse();
    }

    @Test
    void 이전과_다음_위치에_가로선이_없을_경우_그릴_수_있다() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        boolean actual = line.canDraw(1);

        assertThat(actual).isTrue();
    }
}
