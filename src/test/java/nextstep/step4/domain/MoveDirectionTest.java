package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MoveDirectionTest {

    @ParameterizedTest
    @MethodSource("moveDirectionProvider")
    @DisplayName("이동해야하는 Index 값을 move 메서드의 입력으로 사용하면, 이동한 Index 값을 반환한다.")
    void testMove(final MoveDirection moveDirection, final int expectedIdx) {
        //given
        final int startIdx = 1;

        //when
        final int movedIdx = moveDirection.move(startIdx);

        //then
        assertThat(movedIdx).isEqualTo(expectedIdx);
    }

    public static Stream<Arguments> moveDirectionProvider() {
        return Stream.of(
                Arguments.of(MoveDirection.LEFT, 0),
                Arguments.of(MoveDirection.NONE, 1),
                Arguments.of(MoveDirection.RIGHT, 2)
        );
    }
}
