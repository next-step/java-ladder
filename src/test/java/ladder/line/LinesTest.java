package ladder.line;

import ladder.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @DisplayName("참가자가 4명일 때 높이가 3인 사다리를 만들 수 있다.")
    @Test
    void create() {
        Lines lines = new Lines(4, 3, () -> true);

        assertThat(lines).isEqualTo(new Lines(
                List.of(
                        new Line(List.of(true, false, true)),
                        new Line(List.of(true, false, true)),
                        new Line(List.of(true, false, true))
                ))
        );
    }

    @DisplayName("사다리를 이동시켜 마지막 위치를 반환 받을 수 있다.")
    @Test
    void movePoints() {
        Lines lines = new Lines(4, 3, () -> true);

        List<Position> positions = lines.movePoints();

        assertThat(positions)
                .extracting("value")
                .containsExactly(1, 0, 3, 2);
    }
}
