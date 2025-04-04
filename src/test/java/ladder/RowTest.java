package ladder;

import ladder.domain.Bridge;
import ladder.domain.Row;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
    @Test
    public void 설치_가능한_발판_개수_계산() {
        int players = 5;
        int actual = Row.calculateMaxInstallableBridges(players);

        assertThat(actual).isEqualTo(players / 2);
    }

}
