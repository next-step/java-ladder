package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @DisplayName("참여하는 사람 이름이 5글자를 초과하면 예외를 던진다.")
    @Test
    public void create_MoreThanNameLength_ThrowException() {
        String playerName = "highju";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(playerName));
    }
}
