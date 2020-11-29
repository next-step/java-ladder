package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {
    @Test
    @DisplayName("높이만큼 라인 생성")
    void createLines() {
        Lines lines = Lines.fromHeight(3, new ConnectionCreationStrategyImpl());
    }
}
