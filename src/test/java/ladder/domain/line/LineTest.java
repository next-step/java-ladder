package ladder.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("플레이어 수를 기준으로 사다리의 라인을 생성한다.")
    void Line_PlayersCount() {
        final Line expectedLine = new Line(List.of(true, false, true, false, true));

        final Line actualLine = Line.from(new PlayersCount(5), () -> true);

        assertThat(actualLine).isEqualTo(expectedLine);
    }
}
