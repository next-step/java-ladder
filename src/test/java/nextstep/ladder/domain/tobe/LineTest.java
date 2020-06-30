package nextstep.ladder.domain.tobe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Line: List<Point> 사다리의 세로줄 테스트")
class LineTest {

    @DisplayName("width를 입력받아 그 길이만큼 Point 배열이 생성된다")
    @Test
    public void getPoints_ReturnWidth() {
        int width = 5;
        Line line = new Line(width, new FixedLineCreateStrategy());
        assertThat(line.getDirections().size()).isEqualTo(width);
    }

    @DisplayName("생성 시에 width < 2 이라면 예외 발생")
    @Test
    public void create_WidthLessThan2_ExceptionThrown() {
        assertThatThrownBy(() -> {
            Line line = new Line(1, new FixedLineCreateStrategy());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
