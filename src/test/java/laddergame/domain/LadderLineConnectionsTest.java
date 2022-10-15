package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderLineConnectionsTest {

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
                .isThrownBy(() -> new LadderLineConnections(connections));
    }

    @DisplayName("가로 라인이 연속적으로 연결된 경우, 예외가 발생해야 한다.")
    @Test
    void create_givenContinuousConnections() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderLineConnections(
                        List.of(true, true)
                ));
    }

    @DisplayName("Connection의 개수가 0인 경우, Connection이 존재하지 않은 인스턴스를 생성해야 한다.")
    @Test
    void from_givenZero() {
        assertThat(LadderLineConnections.from(0))
                .isEqualTo(new LadderLineConnections(Collections.emptyList()));
    }

    @DisplayName("Connection의 개수가 1인 경우, Connection은 연결되거나 연결되지 않아야 한다.")
    @Test
    void from_givenOne() {
        assertThat(LadderLineConnections.from(1))
                .isIn(
                        new LadderLineConnections(List.of(true)),
                        new LadderLineConnections(List.of(false))
                );
    }

    @DisplayName("Connection의 개수가 0보다 작은 경우, 인스턴스를 생성하면 예외가 발생해야 한다.")
    @Test
    void from_givenNumberOfConnectionsUnderMinValueOfConnecctions() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLineConnections.from(-1));
    }

}
