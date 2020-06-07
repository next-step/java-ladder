package nextstep.ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.point.RandomPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {

    @DisplayName("라인은 사람수 만큼 포인트를 생성한다.")
    @Test
    void line_create_points() {
        Line line = new Line(LinePoints.of(5, new RandomPointGenerator()));
        assertThat(line.getPoints()).hasSize(5);
    }

    @DisplayName("라인 이동 테스트")
    @ParameterizedTest
    @CsvSource(
        value = {
            "0,1",
            "1,0",
            "2,3",
            "3,2",
            "4,4"
        }
    )
    void line_move(int curPosition, int nextPosition) {
        Line line = new Line(LinePoints.of(5, () -> true));

        assertThat(line.move(curPosition)).isEqualTo(nextPosition);
    }

}
