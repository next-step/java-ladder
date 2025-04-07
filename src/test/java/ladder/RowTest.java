package ladder;

import ladder.domain.Bridge;
import ladder.domain.Row;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
    @Test
    public void 설치_가능한_발판_개수_계산() {
        int players = 5;
        int actual = Row.calculateMaxBuildableBridges(players);

        assertThat(actual).isEqualTo(players / 2);
    }

    @Test
    public void 설치하려는_발판_조합_유효성_검사() {
        Bridge first = new Bridge(0);
        Bridge second = new Bridge(1);
        Bridge third = new Bridge(2);

        Set<Bridge> unbuildableBridges = new TreeSet<>();
        unbuildableBridges.add(first);
        unbuildableBridges.add(second);
        unbuildableBridges.add(third);

        Set<Bridge> buildableBridges1 = new TreeSet<>();
        buildableBridges1.add(first);
        buildableBridges1.add(third);

        Set<Bridge> buildableBridges2 = new TreeSet<>();
        buildableBridges2.add(second);

        assertThat(Row.isBuildable(unbuildableBridges)).isFalse();
        assertThat(Row.isBuildable(buildableBridges1)).isTrue();
        assertThat(Row.isBuildable(buildableBridges2)).isTrue();
    }
}
