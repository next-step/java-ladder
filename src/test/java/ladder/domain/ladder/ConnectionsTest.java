package ladder.domain.ladder;


import ladder.exception.OverlapLineException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConnectionsTest {

    private static Stream<Arguments> OverlapConnectionExceptionArgs() {
        return Stream.of(
                arguments(List.of(true,true,false)),
                arguments(List.of(false,true,true)),
                arguments(List.of(false,false,true,true,false))
        );
    }

    @ParameterizedTest
    @MethodSource("OverlapConnectionExceptionArgs")
    @DisplayName("Connections 에 겹치는 부분이 있으면 예외를 던진다.")
    public void OverlapConnectionsExceptionTest(List<Boolean> connections) {
        Assertions.assertThrows(OverlapLineException.class, () -> new Connections(connections));
    }


    private static Stream<Arguments> ConnectionsTestArgs() {
        return Stream.of(
                arguments(List.of(true,false,false), 0, 1),
                arguments(List.of(false,false,false), 0, 0),
                arguments(List.of(false,true,false), 1, 2),
                arguments(List.of(false,false,true), 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("ConnectionsTestArgs")
    @DisplayName("사다리 다음스텝의 이동방향을 테스트 (오른쪽 or 왼쪽 or 제자리) ")
    public void ConnectionsMoveTest(List<Boolean> list, int nowPosition, int resultPosition) {
        assertThat(new Connections(list).move(nowPosition)).isEqualTo(resultPosition);
    }
}