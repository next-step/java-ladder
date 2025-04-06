package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import nextstep.ladder.domain.Height;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    public void 높이는_음수가될수없다() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Height(-1))
            .withMessage("높이는 음수가 될 수 없습니다.");
    }

}
