package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomBridgeGeneratorTest {

    @DisplayName("참가자 수 보다 하나 작은 연결다리 리스트를 만든다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void generateBridges(int numberOfPlayer) {
        BridgeGenerator bridgeGenerator = new RandomBridgeGenerator();

        List<Bridge> bridges = bridgeGenerator.generate(numberOfPlayer);

        assertThat(bridges.size()).isEqualTo(numberOfPlayer - 1);
    }

    @DisplayName("참가자 수가 1이라면 비어있는 List를 반환한다.")
    @Test
    void generateEmptyBridges() {
        BridgeGenerator bridgeGenerator = new RandomBridgeGenerator();

        List<Bridge> bridges = bridgeGenerator.generate(1);

        assertThat(bridges.size()).isEqualTo(0);
    }
}