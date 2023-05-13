package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @ParameterizedTest(name = "[{index}/3] {displayName}")
    @MethodSource("consecutiveConnections")
    @DisplayName("가로 라인의 연결선이 연속해서 존재할 경우, IllegalArgumentException 예외 발생")
    void consecutive_connections_then_throw_IllegalArgumentException(List<Boolean> consecutiveConnections) {
        assertThatThrownBy(() -> new Line(consecutiveConnections))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 라인의 연결선은 연속해서 존재할 수 없습니다.");
    }

    @ParameterizedTest(name = "[{index}/9] {displayName}")
    @MethodSource("validConnections")
    @DisplayName("가로 라인 연견설이 연속해서 존재하지 않을 경우, Line 객체 생성")
    void valid_connections(List<Boolean> validConnections) {
        assertThat(new Line(validConnections))
                .isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("가로 라인의 연결선이 null일 경우, IllegalArgumentException 예외 발생")
    void null_connections_then_throw_IllegalArgumentException() {
        assertThatThrownBy(() -> new Line(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 라인의 연결선은 null이 될 수 없습니다.");
    }

    static Stream<Arguments> consecutiveConnections() {
        return Stream.of(
                Arguments.arguments(List.of(true, true)),
                Arguments.arguments(List.of(false, true, true)),
                Arguments.arguments(List.of(true, true, false))
        );
    }

    static Stream<Arguments> validConnections() {
        return Stream.of(
                Arguments.arguments(List.of()),
                Arguments.arguments(List.of(false)),
                Arguments.arguments(List.of(true)),
                Arguments.arguments(List.of(true, false)),
                Arguments.arguments(List.of(false, true)),
                Arguments.arguments(List.of(true, false, false)),
                Arguments.arguments(List.of(false, true, false)),
                Arguments.arguments(List.of(false, false, true)),
                Arguments.arguments(List.of(true, false, true))
        );
    }
}