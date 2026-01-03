package nextstep.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 참가한_사람_수_만큼_가로_라인을_생성한다() {
        assertThat(new Line(5).getPoints()).hasSize(5);
    }

    @Test
    void 바로_옆_좌표애_라인이_있으면_가로라인을_그리지않는다() {
        // @todo 테스트가 직접적인 계산등의 수에 의존적임

        Line line = new Line(5);
        System.out.println("line = " + line);
        assertThat(
            line.getPoints().stream()
                .filter(Boolean::booleanValue)
                .count()
        ).isLessThanOrEqualTo(3);
    }

}