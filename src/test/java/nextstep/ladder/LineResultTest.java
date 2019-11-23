package nextstep.ladder;

import nextstep.ladder.domain.line.LineResults;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineResultTest {

    @Test
    void positionRangeTest() {
        LineResults lineResults = new LineResults(Collections.singletonList("100, 200, 꽝"));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lineResults.match(-1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            lineResults.match(3);
        });
    }
}
