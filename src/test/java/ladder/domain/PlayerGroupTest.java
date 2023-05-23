package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerGroupTest {

    @DisplayName("플레이어의 이름을 받아서 그룹을 생성할 수 있다.")
    @Test
    public void create_ByPlayerNames_CreateSuccess() {
        String playerNames = "high, june, boem, min, gil";
        PlayerGroup playerGroup = new PlayerGroup(playerNames);
        assertThat(playerGroup.size()).isEqualTo(5);
        assertThat(playerGroup.getPlayerNames()).containsExactly("high"
                , "june", "boem", "min", "gil");
    }
}
