package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LineTest {

    static Stream<Arguments> inputLine2() {
        return Stream.of(
                Arguments.of(List.of(true, true)),
                Arguments.of(List.of(false, true, true))
        );
    }

    static Stream<Arguments> inputLine3() {
        return Stream.of(
                Arguments.of(
                        List.of(new Participant("a"), new Participant("b")),
                        List.of(false),
                        List.of(new Participant("a"), new Participant("b"))),
                Arguments.of(
                        List.of(new Participant("a"), new Participant("b")),
                        List.of(true),
                        List.of(new Participant("b"), new Participant("a"))),
                Arguments.of(
                        List.of(new Participant("a"), new Participant("b"), new Participant("c")),
                        List.of(false, false),
                        List.of(new Participant("a"), new Participant("b"), new Participant("c"))),
                Arguments.of(
                        List.of(new Participant("a"), new Participant("b"), new Participant("c")),
                        List.of(true, false),
                        List.of(new Participant("b"), new Participant("a"), new Participant("c"))),
                Arguments.of(
                        List.of(new Participant("a"), new Participant("b"), new Participant("c")),
                        List.of(false, true),
                        List.of(new Participant("a"), new Participant("c"), new Participant("b")))
        );
    }

    @Test
    @DisplayName("포인트들은 개수는 (참여자들 -1) (6 => 5)")
    void line_size() {
        int size = new Line(6).getLine().size();
        assertThat(size).isEqualTo(5);
    }

    @Test
    @DisplayName("포인트들이 null 또는 empty면 예외(null => IllegalArgumentException, empty => IllegalArgumentException)")
    void not_null_or_empty() {
        assertThatThrownBy(() -> {
            new Line(Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("가로 라인은 겹치면 예외(true,true => IllegalArgumentException | false,true,true => IllegalArgumentException)")
    @MethodSource("inputLine2")
    void legs_should_not_come_out_in_a_row(List<Boolean> input) {
        assertThatThrownBy(() -> {
            new Line(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
