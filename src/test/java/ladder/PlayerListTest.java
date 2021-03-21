package ladder;

import ladder.domain.PlayerList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerListTest {

    @Test
    @DisplayName("플레이어 대량 추가 테스트")
    void addBulk() {
        String[] names = {"pobi","test"};

        PlayerList playerList = PlayerList.of(names);

        assertThat(playerList.size()).isEqualTo(names.length);
    }
}
