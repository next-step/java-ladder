package nextstep.ladder;

import nextstep.ladder.domain.Lines;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {
    @Test
    @DisplayName("같은 높이의 라인을 생성한다")
    void 같은_라인_생성 () {
        Lines lines = new Lines(4);

        Assertions.assertThat(lines.getLineCount()).isEqualTo(4);
    }
}
