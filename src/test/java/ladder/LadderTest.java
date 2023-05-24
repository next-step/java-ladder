package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Line;
import ladder.domain.Width;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("true 이후에는 반드시 false가 생성된다.")
    void generateLineTest() {
        Width width = Width.from(2);

        Line line = new Line(width, () -> true);
        List<Boolean> points = line.getPoints();

        Assertions.assertThat(points).containsExactly(true, false);
    }
}
