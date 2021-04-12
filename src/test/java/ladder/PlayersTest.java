package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {
    @Test
    @DisplayName("플레이어 이름을 담고, 이름을 출력한다.")
    void createPlayersAndPrintPlayerNames() {
        List<String> names = Arrays.asList("djon", "djo", "djoo");
        Players players = new Players(names);

        List<String> expectedNames = players.getAllPlayerNames();

        assertThat(names).isEqualTo(expectedNames);
    }
}
