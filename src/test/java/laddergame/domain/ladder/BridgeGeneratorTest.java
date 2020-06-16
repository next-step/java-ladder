package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BridgeGeneratorTest {

    @DisplayName("참가자 수 보다 하나 작은연결다리 리스트를 만든다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void generateBridges(int numberOfPlayer) {
        List<Bridge> bridges = BridgeGenerator.generate(numberOfPlayer, () -> true);

        assertThat(bridges.size()).isEqualTo(numberOfPlayer - 1);
    }

    @DisplayName("참가자 수가 1명일 때는 연결이 false이고 원소가 1개인 List를 만든다.")
    @Test
    void generateBridgesWhenPlayerNumberIsOne() {
        List<Bridge> bridges = BridgeGenerator.generate(1, () -> true);

        assertAll(
                () -> assertThat(bridges.size()).isEqualTo(1),
                () -> assertThat(bridges.get(0).isConnected()).isFalse()
        );
    }
}