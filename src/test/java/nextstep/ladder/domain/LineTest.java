package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    @DisplayName("width와 사다리 생성 전략을 이용하여 Line 객체를 만들 수 있다.")
    void testLineConstructor() {
        //given
        final int width = 5;
        final BooleanSupplier lineBuilderStrategy = () -> new Random().nextBoolean();

        //when
        final Line line = new Line(width, lineBuilderStrategy);

        //then
        assertThat(line).isNotNull();
    }

    @Test
    @DisplayName("Line이 생성될 때, 연달아 true가 나오는 경우가 없다.")
    void testLineCreationForNoConsecutiveTrueValues() {
        //given
        final int width = 5;
        final BooleanSupplier lineBuilderStrategy = () -> true;

        //when
        final Line line = new Line(width, lineBuilderStrategy);
        final Boolean[] hasRung = line.getHasRung();

        //then
        assertThat(hasRung).isNotEmpty();

        for (int i = 1; i < hasRung.length; i++) {
            assertThat(hasRung[i - 1] && hasRung[i]).isFalse();
        }
    }

    @ParameterizedTest
    @MethodSource("moveUserIdxProvider")
    @DisplayName("userIdx를 입력하고 move 메서드를 실행하면, 입력받은 Idx가 왼쪽 오른쪽 중에 어디로 가야할 지 판단 후 이동한 Idx 값을 반환한다.")
    void testMove(final int userIdx, final int expectedIdx) {
        //given
        final int width = 4;
        final Deque<Boolean> booleans = new ArrayDeque<>(List.of(true, false, false, true));
        final BooleanSupplier lineBuilderStrategy = booleans::pop;

        //when
        final Line line = new Line(width, lineBuilderStrategy);
        final int movedIdx = line.move(userIdx);

        //then
        assertThat(movedIdx).isEqualTo(expectedIdx);
    }

    public static Stream<Arguments> moveUserIdxProvider() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 2),
                Arguments.of(3, 4),
                Arguments.of(4, 3)
        );
    }
}
