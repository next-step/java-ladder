package ladder.domain.ladder;

import ladder.strategy.StepStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LineTest {
    @ParameterizedTest(name = "input = {0}")
    @ValueSource(ints = {2, 3})
    @DisplayName("디딤대는 사람 수 만큼 생성된다.")
    void make_line(int countOfUser) {
        Line line = Line.of(countOfUser);
        assertThat(line.getPoints().size()).isEqualTo(countOfUser - 1);
    }

    @ParameterizedTest(name = "input = {0}")
    @ValueSource(ints = {0, 1})
    @DisplayName("Line 생성 시 countOfUser은 1 이상이어야 한다.")
    void validate_countOfUser(int countOfUser) {
        assertThatThrownBy(() -> Line.of(countOfUser))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line을 생성할 수 없습니다.");
    }

    private static class StepStrategyTest implements StepStrategy {
        private final List<Boolean> results;
        private int index = 0;

        StepStrategyTest(final List<Boolean> results) {
            this.results = results;
        }

        @Override
        public Boolean nextStep() {
            return results.get(index++);
        }
    }

    @ParameterizedTest
    @MethodSource("countOfUserAndResult")
    @DisplayName("Line의 true/false는 외부에서 전략을 주입받아 결정된다.")
    void strategy_true_or_false(int countOfUser, List<Boolean> expected) {
        StepStrategy stepStrategy = new StepStrategyTest(expected);
        Line line = Line.byStrategy(countOfUser, stepStrategy);

        assertThat(line.getPoints()).isEqualTo(expected);
    }

    static Stream<Arguments> countOfUserAndResult() {
        return Stream.of(
                arguments(2, Arrays.asList(true)),
                arguments(2, Arrays.asList(false)),
                arguments(3, Arrays.asList(true, false)),
                arguments(3, Arrays.asList(false, true)),
                arguments(4, Arrays.asList(true, false, false)),
                arguments(4, Arrays.asList(false, false, true)),
                arguments(4, Arrays.asList(false, true, false)));
    }
}