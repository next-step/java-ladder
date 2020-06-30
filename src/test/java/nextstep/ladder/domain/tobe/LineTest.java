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
            new Line(1, new FixedLineCreateStrategy());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("양쪽으로 연결될 수 없음")
    @Test
    public void create_ConnectBothDirection_ExceptionThrown() {
        assertThatThrownBy(() -> {
            new Line(5, new SeriesConnectLineCreateStrategy());
        }).isInstanceOf(IllegalDirectionException.class)
                .hasMessage("Directions cannot be connected in series");
    }

    @DisplayName("첫번째 x 좌표는 왼쪽으로 연결되면 예외 발생")
    @Test
    public void create_FirstDirectionIsLeft_ExceptionThrown() {
        assertThatThrownBy(() -> {
            new Line(5, new LeftConnectLineCreateStrategy());
        }).isInstanceOf(IllegalDirectionException.class)
                .hasMessage("first cannot be connected to left");
    }

    @DisplayName("마지막 x 좌표는 오른쪽으로 연결되면 예외 발생")
    @Test
    public void create_LastDirectionIsRight_ExceptionThrown() {
        assertThatThrownBy(() -> {
            new Line(5, new RightConnectLineCreateStrategy());
        }).isInstanceOf(IllegalDirectionException.class)
                .hasMessage("last cannot be connected to right");
    }
}
