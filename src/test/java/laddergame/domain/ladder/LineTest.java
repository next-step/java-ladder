package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    static BridgeGenerator continuousBridgeGenerator = numberOfPlayer -> {
        Bridge first = Bridge.createRightBridge();
        Bridge second = Bridge.createRightBridge();

        List<Bridge> continuousBridges = new ArrayList<>();
        continuousBridges.add(first);
        continuousBridges.add(second);

        for (int i = 2; i < numberOfPlayer; i++) {
            continuousBridges.add(Bridge.createNotLinkedBridge());
        }

        return continuousBridges;
    };

    @DisplayName("연속으로 연결된 다리가 존재하면 IllegalStateException Throw")
    @Test
    void continuousLineThrowException() {
        assertThatThrownBy(() -> new Line(4, continuousBridgeGenerator))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("연속된 연결 다리가 존재합니다.");
    }
}