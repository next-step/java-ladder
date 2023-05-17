package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {

    @ParameterizedTest
    @MethodSource("addArgs")
    void addTest(int countOfPerson, int height, Ladder expected) {
        assertThat(new Ladder(countOfPerson, height, () -> true)).isEqualTo(expected);
    }

    @Test
    void LadderExceptionTest() {
        assertThatThrownBy(() -> new Ladder(1, 0, () -> true))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사다리 높이는 양수 값을 가져야합니다.");
    }

    static Stream<Arguments> addArgs() {
        return Stream.of(
            Arguments.of(1, 1, new Ladder(List.of(new HorizontalLine(List.of())))),
            Arguments.of(2, 2, new Ladder(List.of(new HorizontalLine(List.of(true)),
                new HorizontalLine(List.of(true)))))
        );
    }

}
