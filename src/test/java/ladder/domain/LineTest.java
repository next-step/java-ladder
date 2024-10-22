package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void 라인_생성_테스트() {
        Line line = new Line(3, () -> true);

        assertThat(line).isEqualTo(new Line(true, false, false));
    }
}
