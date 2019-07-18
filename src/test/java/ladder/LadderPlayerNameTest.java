package ladder;

import ladder.LadderPlayerName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderPlayerNameTest {

    @DisplayName("5글자가 넘는 이름을 입력 했을 때, exception 이 발생 합니다.")
    @Test
    public void testIf5OverInputNameExecuteException() {
        assertThatIllegalStateException().isThrownBy(() -> LadderPlayerName.of("12345678"));
    }
}
