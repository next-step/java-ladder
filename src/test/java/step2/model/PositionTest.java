package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    private Position position;

    private static Stream<Arguments> positionStreamValueForTest() {
        return Stream.of(
                Arguments.of(0, Movement.RIGHT, 1),
                Arguments.of(1, Movement.LEFT, 0),
                Arguments.of(0, Movement.NONE, 0)
        );
    }

    @Test
    void create_Postiion_Object() {
        position = Position.valueOf(2);
        assertThat(position.getPosition()).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource("positionStreamValueForTest")
    @DisplayName("Movement값에 따라서 Position이 옮겨지는지를 확인")
    void move_Position_From_Zero_To_One(int initializer, Movement op, int expected) {
        position = Position.valueOf(initializer);
        position.move(op);
        assertThat(position.getPosition()).isEqualTo(expected);
    }
}
