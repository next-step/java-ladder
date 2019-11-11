package ladder.domain.bridge;

import ladder.domain.common.Range;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeFactoryTest {

    @ParameterizedTest
    @CsvSource({"2,2,4", "3,3,9"})
    void makeLadder(int col, int height, int size) {
        BridgeFactory bridgeFactory = new BridgeFactory(new RandomWay());

        Bridges bridges = bridgeFactory.makeLadder(new Range(col, height));

        assertThat(bridges.getBridges()).hasSize(size);
    }
}