package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    @DisplayName("높이만큼 라인 생성")
    void createLines() {
        Lines lines = Lines.fromHeight(2, 3, new ConnectionCreationStrategyImpl());

        assertThat(lines.getLines()).hasSize(3);
    }
}
