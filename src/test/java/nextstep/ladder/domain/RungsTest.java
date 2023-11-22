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

class RungsTest {
    @Test
    @DisplayName("Rungs 객체를 생성할 수 있다.")
    void testRungsConstructor() {
        //given
        final int width = 5;
        final BooleanSupplier lineBuilderStrategy = () -> new Random().nextBoolean();

        //when
        final Rungs rungs = new Rungs(width, lineBuilderStrategy);

        //then
        assertThat(rungs).isNotNull();
    }


    @Test
    @DisplayName("Rungs가 생성될 때, 연달아 true가 나오는 경우가 없다.")
    void testRungsCreationForNoConsecutiveTrueValues() {
        //given
        final int width = 5;
        final BooleanSupplier lineBuilderStrategy = () -> true;

        //when
        final Rungs rungs = new Rungs(width, lineBuilderStrategy);
        final Boolean[] hasRung = rungs.rungs();

        //then
        assertThat(hasRung).isNotEmpty();

        for (int i = 1; i < hasRung.length; i++) {
            assertThat(hasRung[i - 1] && hasRung[i]).isFalse();
        }
    }

    @ParameterizedTest
    @MethodSource("inputHasRungAtIdxProvider")
    @DisplayName("hasRungAtIdx 메서드로 확인하고 싶은 idx를 넣으면, 해당 idx의 rung 유무를 반환한다.")
    void testHasRungAtIdx(final int checkIdx, final boolean expected) {
        //given
        final int width = 5;
        Deque<Boolean> booleans = new ArrayDeque<>(List.of(true, false, false, true, false));
        final BooleanSupplier lineBuilderStrategy = booleans::pop;

        //when
        final Rungs rungs = new Rungs(width, lineBuilderStrategy);
        final boolean hasRung = rungs.hasRungAtIdx(checkIdx);

        //then
        assertThat(hasRung).isEqualTo(expected);
    }

    public static Stream<Arguments> inputHasRungAtIdxProvider() {
        return Stream.of(
                Arguments.of(0, true),
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(3, true),
                Arguments.of(4, false)
        );
    }
}
