package step2.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementTest {

    private static Stream<Arguments> getAllTheValuesOfMovement() {
        return Stream.of(
                Arguments.of(Movement.LEFT, -1),
                Arguments.of(Movement.RIGHT, 1),
                Arguments.of(Movement.NONE, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getAllTheValuesOfMovement")
    void create_Movement_Enum_And_CheckValue(Movement op, int expected) {
        assertThat(op.getDirection()).isEqualTo(expected);
    }


}
