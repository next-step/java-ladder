package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderLineTest {

    private static List<Arguments> provideCorrectConnections() {
        return List.of(
                Arguments.of(List.of(false, false)),
                Arguments.of(List.of(false, true)),
                Arguments.of(List.of(true, false))
        );
    }

    @DisplayName("가로 라인이 연속적으로 연결되지 않은 경우, 예외가 발생하지 않아야 한다.")
    @ParameterizedTest
    @MethodSource("provideCorrectConnections")
    void create(List<Boolean> connections) {
        assertThatNoException()
                .isThrownBy(() -> new LadderLine(connections));
    }

    @DisplayName("가로 라인이 연속적으로 연결된 경우, 예외가 발생해야 한다.")
    @Test
    void create_givenContinuousConnections() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLine(
                        List.of(true, true)
                ));
    }

    @DisplayName("위치 인덱스가 주어지면, 연결된 방향을 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0,RIGHT",
            "1,LEFT",
            "2,NONE",
    })
    void getConnectedDirection(int indexOfPosition, LadderConnectedDirection expected) {
        LadderLine line = new LadderLine(List.of(true, false));
        assertThat(line.getConnectedDirection(indexOfPosition)).isEqualTo(expected);
    }

}
