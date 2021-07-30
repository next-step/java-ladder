package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.ladder.Step;
import nextstep.ladder.exception.NullArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.RETURN_FALSE_RANDOM;
import static nextstep.ladder.domain.Fixture.RETURN_TRUE_RANDOM;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("랜덤 발판 생성 전략 클래스 테스트")
class RandomGenerateStrategyTempTest {

    @DisplayName("랜덤 객체를 가지고 초기화한다")
    @Test
    void init() {
        assertThat(RandomGenerateStrategyTemp.init(new Random())).isInstanceOf(RandomGenerateStrategyTemp.class);
    }

    @DisplayName("랜덤 객체가 null 일 경우 예외를 발생 시킨다")
    @Test
    void initException() {
        assertThatThrownBy(() -> RandomGenerateStrategyTemp.init(null)).isInstanceOf(NullArgumentException.class);
    }

    @DisplayName("랜덤 객체가 특정 값만 반환할 때의 첫번째 열의 발판 생성 테스트")
    @MethodSource
    @ParameterizedTest
    void generateFirst(Random random, Step expectedStep) {
        RandomGenerateStrategyTemp randomGenerateStrategy = RandomGenerateStrategyTemp.init(random);

        assertThat(randomGenerateStrategy.generateFirst()).isEqualTo(expectedStep);
    }

    private static Stream<Arguments> generateFirst() {
        return Stream.of(
                Arguments.of(RETURN_TRUE_RANDOM, Step.RIGHT),
                Arguments.of(RETURN_FALSE_RANDOM, Step.NONE)
        );
    }

    @DisplayName("랜덤 객체가 특정 값만 반환할 때의 첫번째 열의 발판 생성 테스트")
    @MethodSource
    @ParameterizedTest
    void generateMiddle(Step prevStep, Random random, Step expectedStep) {
        RandomGenerateStrategyTemp randomGenerateStrategy = RandomGenerateStrategyTemp.init(random);

        assertThat(randomGenerateStrategy.generateMiddle(prevStep)).isEqualTo(expectedStep);
    }

    private static Stream<Arguments> generateMiddle() {
        return Stream.of(
                Arguments.of(Step.RIGHT, RETURN_TRUE_RANDOM, Step.LEFT),
                Arguments.of(Step.LEFT, RETURN_TRUE_RANDOM, Step.RIGHT),
                Arguments.of(Step.NONE, RETURN_TRUE_RANDOM, Step.RIGHT),
                Arguments.of(Step.RIGHT, RETURN_FALSE_RANDOM, Step.LEFT),
                Arguments.of(Step.LEFT, RETURN_FALSE_RANDOM, Step.NONE),
                Arguments.of(Step.NONE, RETURN_FALSE_RANDOM, Step.NONE)
        );
    }

    @DisplayName("랜덤 객체가 특정 값만 반환할 때의 첫번째 열의 발판 생성 테스트")
    @MethodSource
    @ParameterizedTest
    void generateLast(Step prevStep, Random random, Step expectedStep) {
        RandomGenerateStrategyTemp randomGenerateStrategy = RandomGenerateStrategyTemp.init(random);

        assertThat(randomGenerateStrategy.generateLast(prevStep)).isEqualTo(expectedStep);
    }

    private static Stream<Arguments> generateLast() {
        return Stream.of(
                Arguments.of(Step.RIGHT, RETURN_TRUE_RANDOM, Step.LEFT),
                Arguments.of(Step.LEFT, RETURN_TRUE_RANDOM, Step.NONE),
                Arguments.of(Step.NONE, RETURN_TRUE_RANDOM, Step.NONE),
                Arguments.of(Step.RIGHT, RETURN_FALSE_RANDOM, Step.LEFT),
                Arguments.of(Step.LEFT, RETURN_FALSE_RANDOM, Step.NONE),
                Arguments.of(Step.NONE, RETURN_FALSE_RANDOM, Step.NONE)
        );
    }
}
