package ladder2;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import nextstep.ladder2.domain.player.NxPlayer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NxPlayerTest {
    @Test
    @DisplayName("사람 이름은 최대 5글자까지 가능하다.")
    void playerNameLengthLimitedToFive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new NxPlayer("djoon1"))
                .withMessage("사람 이름은 최대 5글자까지 입력 가능합니다.");
    }
}
