package nextstep.ladder.domain.ladders;

import nextstep.ladder.domain.fixture.FixedLineCreateStrategy;
import nextstep.ladder.domain.result.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Ladder: List<Line> 을 가지고 있는 가로세로 연결된 사다리 테스트")
class LadderTest {

    @DisplayName("height를 입력받아 높이만큼 Line 배열이 생성된다")
    @Test
    public void getLines_ReturnHeight() {
        int height = 5;
        Ladder ladder = new Ladder(height, 5, new RandomLineCreateStrategy());
        assertThat(ladder.getLines().size()).isEqualTo(height);
    }

    @DisplayName("생성 시에 height < 1 이라면 예외 발생")
    @Test
    public void create_HeightLessThan1_ExceptionThrown() {
        assertThatThrownBy(() -> {
            new Ladder(0, 5, new RandomLineCreateStrategy());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 시작점에서의 결과 도착점을 반환한다")
    @ParameterizedTest
    @MethodSource("source_getLastPosition_ReturnLastPosition")
    public void getLastPosition_ReturnLastPosition(Point point, int expected) {
        Ladder ladder = new Ladder(5, 4, new FixedLineCreateStrategy());
        assertThat(ladder.getLastPosition(point)).isEqualTo(expected);
    }

    public static Stream<Arguments> source_getLastPosition_ReturnLastPosition() {
        return Stream.of(
                Arguments.of(new Point(0), 0),
                Arguments.of(new Point(1), 3),
                Arguments.of(new Point(2), 2),
                Arguments.of(new Point(3), 1));
    }
}
