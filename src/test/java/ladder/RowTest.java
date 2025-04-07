package ladder;

import ladder.domain.Bridge;
import ladder.domain.Row;
import ladder.generator.FixedBridgeGenerator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {
    @Test
    public void 설치_가능한_발판_개수_계산() {
        int players = 5;
        int actual = Row.calculateMaxBuildableBridges(players);

        assertThat(actual).isEqualTo(players / 2);
    }

    @Test
    public void 행_생성시_발판의_연속적인_설치를_막는다() {
        int playerCount = 5;

        Bridge first = Bridge.CONNECTED;
        Bridge second = Bridge.CONNECTED;
        Bridge third = Bridge.CONNECTED;
        Bridge fourth = Bridge.CONNECTED;
        Queue<Bridge> bridges = new LinkedList<>(List.of(first, second, third, fourth));

        Row row = Row.generateRow(playerCount, new FixedBridgeGenerator(bridges));

        for (int i = 1; i < playerCount; i++) {
            assertThat(row.isConnected(i - 1) && row.isConnected(i)).isFalse();
        }

    }
}
