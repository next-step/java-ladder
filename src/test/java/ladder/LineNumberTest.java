package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ladder.domain.LineNumber;

public class LineNumberTest {
    @Test
    void 생성_테스트() {
        LineNumber lineNumber = LineNumber.valueOf(0);
        assertThat(lineNumber).isEqualTo(LineNumber.valueOf(0));
    }

    @Test
    void 유효성_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> LineNumber.valueOf(-1));
    }
}
