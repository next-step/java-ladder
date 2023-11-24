package nextstep.step4.responsibility.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IndexHorizontalMoverTest {

    @ParameterizedTest
    @MethodSource("indexHorizontalMoversProvider")
    @DisplayName("각 Mover는 입력으로 받은 Index를 이동시킨다.")
    void moveHorizontal(IndexHorizontalMover mover, int expectedIdx) {
        // given
        int originalIdx = 1;

        // when
        final int movedIdx = mover.moveHorizontal(originalIdx);

        // then
        assertThat(movedIdx).isEqualTo(expectedIdx);
    }

    public static Stream<Arguments> indexHorizontalMoversProvider() {
        return Stream.of(
                Arguments.of(new LeftMover(), 0),
                Arguments.of(new NoneMover(), 1),
                Arguments.of(new RightMover(), 2)
        );
    }
}
