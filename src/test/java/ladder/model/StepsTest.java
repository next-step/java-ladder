package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StepsTest {

    private static Stream<Arguments> provideForCreate() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(new Step(0, new Direction(false, true)),
                                              new Step(1, new Direction(true, false)),
                                              new Step(2, new Direction(false, false)))),

                Arguments.of(4, Arrays.asList(new Step(0, new Direction(false, true)),
                                              new Step(1, new Direction(true, false)),
                                              new Step(2, new Direction(false, true)),
                                              new Step(3, new Direction(true, false)))),

                Arguments.of(2, Arrays.asList(new Step(0, new Direction(false, true)),
                                              new Step(1, new Direction(true, false))))
        );
    }

    @ParameterizedTest
    @MethodSource("provideForCreate")
    @DisplayName("Steps 생성하기")
    void create(int countOfSteps, List<Step> expected) {
        // given
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;

        // when
        Steps result = Steps.of(countOfSteps, alwaysGenerateStrategy);

        // then
        assertThat(result.getSteps()).isEqualTo(expected);
    }

    @Test
    @DisplayName("Steps 생성 실패하기 : step갯수가 1이하로 들어오는 경우")
    void create_fail() {
        assertThatThrownBy(() -> Steps.of(1, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("step은 최소 두 개 이상입니다.");

    }

    @Test
    @DisplayName("위치 이동하기")
    void move() {
        // given
        LadderGenerateStrategy alwaysGenerateStrategy = () -> true;
        Steps steps = Steps.of(4, alwaysGenerateStrategy);

        // when
        int result1 = steps.move(0);
        int result2 = steps.move(1);

        // then
        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(0);
    }

}
