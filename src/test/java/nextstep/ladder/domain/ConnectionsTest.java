package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class ConnectionsTest {
    @ParameterizedTest(name = "[{index}/3] {displayName}")
    @MethodSource("consecutiveConnections")
    @DisplayName("가로 라인의 연결선이 연속해서 존재할 경우, IllegalArgumentException 예외 발생")
    void consecutive_connections_then_throw_IllegalArgumentException(List<Connection> consecutiveConnections) {
        assertThatThrownBy(() -> new Connections(consecutiveConnections))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 라인의 연결선은 연속해서 존재할 수 없습니다.");
    }

    @ParameterizedTest(name = "[{index}/9] {displayName}")
    @MethodSource("validConnections")
    @DisplayName("가로 라인 연견설이 연속해서 존재하지 않을 경우, Connections 객체 생성")
    void valid_connections(List<Connection> validConnections) {
        assertThat(new Connections(validConnections))
                .isInstanceOf(Connections.class);
    }

    @Test
    @DisplayName("가로 라인의 연결선이 null일 경우, IllegalArgumentException 예외 발생")
    void null_connections_then_throw_IllegalArgumentException() {
        assertThatThrownBy(() -> new Connections(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("가로 라인의 연결선은 null이 될 수 없습니다.");
    }

    static Stream<Arguments> consecutiveConnections() {
        return Stream.of(
                Arguments.arguments(List.of(new Connection(true), new Connection(true))),
                Arguments.arguments(List.of(new Connection(false), new Connection(true), new Connection(true))),
                Arguments.arguments(List.of(new Connection(true), new Connection(true), new Connection(false)))
        );
    }

    static Stream<Arguments> validConnections() {
        return Stream.of(
                Arguments.arguments(List.of()),
                Arguments.arguments(List.of(new Connection(false))),
                Arguments.arguments(List.of(new Connection(true))),
                Arguments.arguments(List.of(new Connection(true), new Connection(false))),
                Arguments.arguments(List.of(new Connection(false), new Connection(true))),
                Arguments.arguments(List.of(new Connection(true), new Connection(false), new Connection(false))),
                Arguments.arguments(List.of(new Connection(false), new Connection(true), new Connection(false))),
                Arguments.arguments(List.of(new Connection(false), new Connection(false), new Connection(true))),
                Arguments.arguments(List.of(new Connection(true), new Connection(false), new Connection(true)))
        );
    }
}