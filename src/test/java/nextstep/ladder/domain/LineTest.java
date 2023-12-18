package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    @DisplayName("같은 라인에 연속으로 설정되는 경우 Exception Throw")
    void line_연속생성불가_Test() {
        LineGenerator lineGenerator = new LineGenerator() {
            @Override
            public boolean generateLine() {
                return true;
            }
        };

        assertThrows(IllegalArgumentException.class, () -> LineState.previousOf(true , lineGenerator));
    }
}
