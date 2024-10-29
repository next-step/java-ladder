package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HorizontalLineTest {
    @Test
    void 생성된_가로선은_연속되지_않아야_한다() {
        // given
        int userCount = 4;

        // when
        HorizontalLine horizontalLine = new HorizontalLine(userCount);

        // then
        for (int i = 0; i < horizontalLine.size() - 1; i++) {
            boolean currentGeneratedLine = horizontalLine.hasLineOnIndex(i);
            boolean nextGeneratedLine = horizontalLine.hasLineOnIndex(i + 1);
            Assertions.assertThat(currentGeneratedLine).isNotEqualTo(nextGeneratedLine);
        }
    }
}
