package ladder;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import nextstep.ladder.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    @Test
    @DisplayName("사람 이름은 최대 5글자까지 가능하다.")
    void playerNameLengthLimitedToFive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("djoon1"))
                .withMessage("사람 이름은 최대 5글자까지 입력 가능합니다.");
    }
}
