package nextstep.ladder.line;

import nextstep.ladder.domain.line.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    @DisplayName("라인 목록 생성 함수")
    void create() {
        assertThat(new Lines(3, 4))
                .extracting("lines")
                .asList()
                .hasSize(3);
    }
}
