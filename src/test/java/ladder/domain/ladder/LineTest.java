package ladder.domain.ladder;

import ladder.exception.OverlapLineException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LineTest {

    private static Stream<Arguments> LineArgs() {
        return Stream.of(
                arguments(List.of(true,true,false)),
                arguments(List.of(false,true,true)),
                arguments(List.of(false, false, true ,true,false))
        );
    }

    @ParameterizedTest
    @MethodSource("LineArgs")
    @DisplayName("하나의 Line 에 겹치는 부분이 있으면 예외를 던진다.")
    public void OverlapLineExceptionTest(List<Boolean> line) {
        Assertions.assertThrows(OverlapLineException.class, () -> new Line(line));
    }

}