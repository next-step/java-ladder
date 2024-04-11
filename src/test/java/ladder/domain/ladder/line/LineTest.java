package ladder.domain.ladder.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.ladder.Width;

class LineTest {

    @Test
    @DisplayName("사다리 너비를 기준으로 사다리의 라인을 생성한다.")
    void Line_PlayersCount() {
        final Line expectedLine = new Line(List.of(true, false, true, false));

        final Line actualLine = Line.of(new Width(5), () -> true);

        assertThat(actualLine).isEqualTo(expectedLine);
    }

    @Test
    @DisplayName("라인 연결 상태에 따라 포지션을 이동한다.")
    void Move_Positions() {
        final Line line = new Line(List.of(true, false, true, false));
        final Map<Integer, Integer> actualRoute = new HashMap<>() {{
            put(0, 0);
            put(1, 1);
            put(2, 2);
            put(3, 3);
        }};
        final Map<Integer, Integer> expectedRoute = Map.of(
                0, 1,
                1, 0,
                2, 3,
                3, 2
        );

        line.move(actualRoute);

        assertThat(actualRoute).isEqualTo(expectedRoute);
    }
}
