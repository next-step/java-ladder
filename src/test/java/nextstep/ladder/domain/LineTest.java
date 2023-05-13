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
    @MethodSource("invalidConnections")
    @DisplayName("가로 라인의 연결선이 연속해서 존재할 경우, IllegalArgumentException 예외 발생")
    void invalid_connections(List<Boolean> invalidConnections) {
        assertThatThrownBy(() -> new Line(invalidConnections))
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

    static Stream<Arguments> invalidConnections() {
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