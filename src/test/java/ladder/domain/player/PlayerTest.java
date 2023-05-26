package ladder.domain.player;

import ladder.domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    @DisplayName("참여하는 사람이름 값이 null이면 예외를 던진다.")
    public void create_NameIsNull_ThrowException() {
        Assertions.assertThatNullPointerException()
                .isThrownBy(() -> new Player(null))
                .withMessageContaining("참여자의 이름값은 null일 수 없습니다.");
    }

    @DisplayName("참여하는 사람 이름이 5글자를 초과하면 예외를 던진다.")
    @Test
    public void create_MoreThanNameLength_ThrowException() {
        String playerName = "highju";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(playerName));
    }
}
