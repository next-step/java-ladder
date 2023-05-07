package nextstep.ladder.line;

import nextstep.ladder.domain.line.Lines;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {
    @Test
    @DisplayName("라인 목록 생성 함수")
    void create() {
        Assertions.assertThat(new Lines(3, 4))
                .extracting("lines")
                .asList()
                .hasSize(3);
    }
}
