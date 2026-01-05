package nextstep.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

    @Test
    void 참가한_사람_수_만큼_가로_라인을_생성한다() {
        assertThat(new Line(5).points()).hasSize(5);
    }

    @Test
    void 모든_라인이_false_이면_예외전파() {
        assertThatThrownBy(() -> {
            new Line(false, false, false);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("모든 라인이 false일 수 없습니다");
    }

    @Test
    void 인접이_서로_true_이면_예외전파() {
        assertThatThrownBy(() -> {
            new Line(true, true, false);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("인접라인이 서로 true일수 없습니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void true_개수는_인접금지_규칙상_최대치를_넘지않는다(int countOfPerson) {
        Line line = new Line(countOfPerson);
        int maxTrue = (line.points().size() + 1) / 2;

        assertThat(
            line.points().stream()
                .filter(Boolean::booleanValue)
                .count()
        ).isLessThanOrEqualTo(maxTrue);
    }

}