package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    static BridgeGenerator switchingBridgeGenerator = new BridgeGenerator() {
        @Override
        public List<Bridge> generate(int numberOfPlayer) {
            if (numberOfPlayer == 1) {
                return Arrays.asList(Bridge.createNotLinkedBridge());
            }

            if (numberOfPlayer % 2 == 0) {
                return IntStream.range(0, numberOfPlayer)
                        .mapToObj(this::createBridge)
                        .collect(Collectors.toList());
            }

            List<Bridge> bridges = IntStream.range(0, numberOfPlayer - 1)
                    .mapToObj(this::createBridge)
                    .collect(Collectors.toList());

            bridges.add(Bridge.createNotLinkedBridge());

            return bridges;
        }

        private Bridge createBridge(int index) {
            if (index % 2 == 0) {
                return Bridge.createRightBridge();
            }

            return Bridge.createLeftBridge();
        }
    };

    @DisplayName("사다리 높이가 1보다 작으면 IllegalArgumentExceptionThrow")
    @Test
    void minLadderHeightThrowException() {
        int ladderHeight = 0;
        int numberOfPlayer = 1;
        assertThatThrownBy(() -> new Ladder(ladderHeight, numberOfPlayer, switchingBridgeGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이가 너무 작습니다. - " + ladderHeight);

    }

    @DisplayName("사다리 높이와 참여 인원수에 맞는 사다리를 만든다.")
    @ParameterizedTest
    @CsvSource({"1, 2", "2, 4", "2, 1"})
    void createLadder(int ladderHeight, int numberOfPlayer) {
        Ladder ladder = new Ladder(ladderHeight, numberOfPlayer, switchingBridgeGenerator);

        List<Line> lines = ladder.getLines();
        List<Bridge> bridges = lines.get(0).getBridges();

        assertAll(
                () -> assertThat(lines.size()).isEqualTo(ladderHeight),
                () -> assertThat(bridges.size()).isEqualTo(numberOfPlayer)
        );
    }
}