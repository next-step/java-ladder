package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineFactoryTest {
    @DisplayName("라인 객체를 리턴한다.")
    @ParameterizedTest
    @MethodSource("instanceSet")
    void instance(Line line, Class type) {
        assertThat(line).isInstanceOf(type);
    }

    @DisplayName("사람 수가 0보다 작으면 IllegalArgumentException 예외를 발생시킨다.")
    @Test
    void get_when_invalid_count_of_person() {
        assertThatThrownBy(() -> LineFactory.edge(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The number of participants is greater than zero.");

        assertThatThrownBy(() -> LineFactory.body(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The number of participants is greater than zero.");
    }
    
    private static Stream<Arguments> instanceSet() {
        return Stream.of(
                Arguments.arguments(LineFactory.edge(3), EdgeLine.class),
                Arguments.arguments(LineFactory.body(3), BodyLine.class)
        );
    }
}
