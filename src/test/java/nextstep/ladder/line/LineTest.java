package nextstep.ladder.line;

import nextstep.ladder.domain.line.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("라인 생성 테스트")
    void create() {
        assertThat(new Line(3))
                .extracting("points")
                .asList()
                .hasSize(3);
    }
}
