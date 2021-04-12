package ladder;

import ladder.domain.engine.Players;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {
    @Test
    public void Players_참여자수_Test(){
        assertThatThrownBy(() -> new Players(new String[]{"pobi"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는 2명 이상이어야 합니다.");
    }
}
