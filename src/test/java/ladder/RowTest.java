package ladder;

import ladder.domain.Bridge;
import ladder.domain.Row;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
    @Test
    public void 설치_가능한_발판_개수_계산() {
        int players = 5;
        int actual = Row.calculateMaxInstallableBridges(players);

        assertThat(actual).isEqualTo(players / 2);
    }

    @Test
    public void 설치하려는_발판_조합_유효성_검사() {
        Bridge first = new Bridge(0);
        Bridge second = new Bridge(1);
        Bridge third = new Bridge(2);

        assertThat(Row.isInstallable(List.of(first, second))).isFalse();
        assertThat(Row.isInstallable(List.of(first, third))).isTrue();
        assertThat(Row.isInstallable(List.of(second, third))).isFalse();
    }
}
