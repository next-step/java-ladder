package nextstep.ladder.domain.tobe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Line: List<Point> 사다리의 세로줄 테스트")
class LineTest {

    @DisplayName("width를 입력받아 그 길이만큼 Point 배열이 생성된다")
    @Test
    public void getPoints_ReturnWidth() {
        int width = 5;
        Line line = new Line(width, new FixedLineCreateStrategy());
        assertThat(line.getDirections().size()).isEqualTo(width);
    }
}
