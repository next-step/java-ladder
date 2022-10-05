package ladder.step2.domain;

import ladder.step2fixture.domain.LineFixture;
import ladder.step2fixture.domain.PartLineFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    @DisplayName("라인 생성 성공")
    void create_line_success() {
        assertThat(LineFixture.LINE).isNotNull();
    }
    
    @Test
    @DisplayName("부분 라인이 겹칠 경우 예외")
    void overlapping_line_exception() {
        List<PartLine> partLines = Arrays.asList(PartLineFixture.FALSE, PartLineFixture.TRUE, PartLineFixture.TRUE, PartLineFixture.FALSE);
        
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(partLines))
                .withMessage("부분 라인이 겹칩니다.");
    }
    
    @Test
    @DisplayName("첫번째 부분 라인이 있는 경우 예외")
    void exist_first_line_exception() {
        List<PartLine> partLines = Arrays.asList(PartLineFixture.TRUE, PartLineFixture.FALSE, PartLineFixture.FALSE, PartLineFixture.FALSE);
        
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(partLines))
                .withMessage("첫번째 부분 라인이 존재합니다.");
    }
}
