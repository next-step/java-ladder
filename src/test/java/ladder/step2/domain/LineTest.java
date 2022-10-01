package ladder.step2.domain;

import ladder.step2.domain.strategy.RandomLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    public static final Line LINE = new RandomLineCreateStrategy().createLine(5);
    
    @Nested
    @DisplayName("라인 생성 성공")
    class CreateLineSuccess {
        @RepeatedTest(100)
        void create_line_success() {
            Line line = new RandomLineCreateStrategy().createLine(5);
            assertThat(line).isNotNull();
        }
    }
    
    @Test
    @DisplayName("부분 라인이 겹칠 경우 예외")
    void overlapping_line_exception() {
        List<PartLine> partLines = Arrays.asList(PartLineTest.FALSE, PartLineTest.TRUE, PartLineTest.TRUE, PartLineTest.FALSE);
        
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(partLines))
                .withMessage("부분 라인이 겹칩니다.");
    }
    
    @Test
    @DisplayName("첫번째 부분 라인이 있는 경우 예외")
    void exist_first_line_exception() {
        List<PartLine> partLines = Arrays.asList(PartLineTest.TRUE, PartLineTest.FALSE, PartLineTest.FALSE, PartLineTest.FALSE);
        
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(partLines))
                .withMessage("첫번째 부분 라인이 존재합니다.");
    }
}
