package nextstep.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

    @Test
    void 참가한_사람_수_만큼_가로_라인을_생성한다() {
        assertThat(new Line(5).getPoints()).hasSize(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void true_개수는_인접금지_규칙상_최대치를_넘지않는다(int countOfPerson) {
        Line line = new Line(countOfPerson);
        int maxTrue = (line.getPoints().size() + 1) / 2;

        assertThat(
            line.getPoints().stream()
                .filter(Boolean::booleanValue)
                .count()
        ).isLessThanOrEqualTo(maxTrue);
    }

}