package ladder;

import ladder.domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {

    @DisplayName("높이는 2 이상")
    @Test
    void 높이_2이하_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> new Height(1))
                .withMessage("높이는 2 이상부터 가능합니다.");
    }
}
