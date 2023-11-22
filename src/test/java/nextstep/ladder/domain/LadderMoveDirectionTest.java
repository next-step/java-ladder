package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderMoveDirectionTest {
    @ParameterizedTest
    @MethodSource("inputLadderMoveDirectionProvider")
    @DisplayName("move 메서드를 사용하면, 각 Direction에 따라 idx 값이 이동한다.")
    void testMove(final LadderMoveDirection moveDirection, final int expectedIdx) {
        //given
        final int startIdx = 1;

        //when
        final int movedIdx = moveDirection.move(startIdx);

        //then
        assertThat(movedIdx).isEqualTo(expectedIdx);
    }

    public static Stream<Arguments> inputLadderMoveDirectionProvider() {
        return Stream.of(
                Arguments.of(LadderMoveDirection.LEFT, 0),
                Arguments.of(LadderMoveDirection.CENTER, 1),
                Arguments.of(LadderMoveDirection.RIGHT, 2)
        );
    }
}
