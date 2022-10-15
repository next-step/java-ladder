package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
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

    @DisplayName("세로 막대의 개수가 1개인 경우, 세로 막대에 연결된 것이 없어야 한다.")
    @Test
    void from_givenOneColumn() {
        assertThat(LadderLine.from(1))
                .isEqualTo(new LadderLine(Collections.emptyList()));
    }

    @DisplayName("세로 막대의 개수가 2개인 경우, 세로 막대는 연결되거나 연결되지 않아야 한다.")
    @Test
    void from_givenTwoColumns() {
        assertThat(LadderLine.from(2))
                .isIn(
                        new LadderLine(List.of(true)),
                        new LadderLine(List.of(false))
                );
    }

    @DisplayName("세로 막대의 개수가 1보다 작은 경우, 예외가 발생해야 한다.")
    @Test
    void from_givenNumberOfColumnsUnderMinValueOfColumns() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLine.from(0));
    }

}
