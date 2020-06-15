package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("사다리 수평라인 생성 테스트")
class LineTest {

    @DisplayName("사다리의 수평라인을 생성할 수 있다")
    @ParameterizedTest
    @MethodSource("source_create_validParam_shouldSuccess")
    public void create_validParam_shouldSuccess(List<Boolean> booleanList) {
        Line line = new Line(booleanList);
    }

    public static Stream<Arguments> source_create_validParam_shouldSuccess() {
        return Stream.of(
                Arguments.of(Arrays.asList(false, true, false, true)),
                Arguments.of(Arrays.asList(false, false, false, true)),
                Arguments.of(Arrays.asList(false, true, false, false)),
                Arguments.of(Arrays.asList(false, true, false, false, false, true)),
                Arguments.of(Arrays.asList(false, false, true, false, true, false)));
    }

    @DisplayName("사다리가 연속으로 연결될 수 없다")
    @ParameterizedTest
    @MethodSource("source_create_invalidParam_shouldFail")
    public void create_invalidParam_shouldFail(List<Boolean> booleanList) {
        assertThatThrownBy(() -> {
            Line line = new Line(booleanList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> source_create_invalidParam_shouldFail() {
        return Stream.of(
                Arguments.of(Arrays.asList(false, true, true, true)),
                Arguments.of(Arrays.asList(false, false, true, true)),
                Arguments.of(Arrays.asList(false, true, true, false)),
                Arguments.of(Arrays.asList(false, true, false, false, true, true)),
                Arguments.of(Arrays.asList(false, false, true, false, true, true)));
    }

    @DisplayName("0번 위치에 사다리가 연결될 수 없다")
    @ParameterizedTest
    @MethodSource("source_create_zeroPositionHolder_shouldFail")
    public void create_zeroPositionHolder_shouldFail(List<Boolean> booleanList) {
        assertThatThrownBy(() -> {
            Line line = new Line(booleanList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> source_create_zeroPositionHolder_shouldFail() {
        return Stream.of(
                Arguments.of(Arrays.asList(true, true, false, true)),
                Arguments.of(Arrays.asList(true, false, false, true)),
                Arguments.of(Arrays.asList(true, true, false, false)),
                Arguments.of(Arrays.asList(true, true, false, false, false, true)),
                Arguments.of(Arrays.asList(true, false, true, false, true, false)));
    }
}
