package nextstep.ladder.domain.tobe;

import nextstep.ladder.domain.tobe.fixture.FixedLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("Ladder: List<Line> 을 가지고 있는 가로세로 연결된 사다리 테스트")
class LadderTest {

    @DisplayName("height를 입력받아 높이만큼 Line 배열이 생성된다")
    @Test
    public void getLines_ReturnHeight() {
        int height = 5;
        Ladder ladder = new Ladder(height, 5);
        assertThat(ladder.getLines().size()).isEqualTo(height);
    }

    @DisplayName("생성 시에 height < 1 이라면 예외 발생")
    @Test
    public void create_HeightLessThan1_ExceptionThrown() {
        assertThatThrownBy(() -> {
            new Ladder(0, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
