package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomBridgeGeneratorTest {

    @DisplayName("참가자 수와 같은 연결다리 리스트를 만든다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void generateBridges(int numberOfPlayer) {
        BridgeGenerator bridgeGenerator = new RandomBridgeGenerator();

        List<Bridge> bridges = bridgeGenerator.generate(numberOfPlayer);

        assertThat(bridges.size()).isEqualTo(numberOfPlayer);
    }
}