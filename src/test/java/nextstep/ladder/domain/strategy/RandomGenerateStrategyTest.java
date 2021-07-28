package nextstep.ladder.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("랜덤 발판 생성 전략 클래스 테스트")
class RandomGenerateStrategyTest {

    @DisplayName("랜덤 객체를 가지고 초기화한다")
    @Test
    void init() {
        assertThat(RandomGenerateStrategy.init(new Random())).isInstanceOf(RandomGenerateStrategy.class);
    }

    @DisplayName("랜덤 객체가 null 일 경우 예외를 발생 시킨다")
    @Test
    void initException() {
        assertThatThrownBy(() -> RandomGenerateStrategy.init(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 객체가 리턴하는 값을 그대로 리턴한다")
    @MethodSource
    @ParameterizedTest
    void isGenerable(Random random, boolean expectedValue) {
        RandomGenerateStrategy randomGenerateStrategy = RandomGenerateStrategy.init(random);

        assertThat(randomGenerateStrategy.isGenerable()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> isGenerable() {
        return Stream.of(
                Arguments.of(new Random() {
                    @Override
                    public boolean nextBoolean() {
                        return true;
                    }
                }, true),
                Arguments.of(new Random() {
                    @Override
                    public boolean nextBoolean() {
                        return false;
                    }
                }, false)
        );
    }
}
