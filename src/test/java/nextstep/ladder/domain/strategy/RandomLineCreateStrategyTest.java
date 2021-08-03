package nextstep.ladder.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RandomLineCreateStrategyTest {
    @DisplayName("랜덤객체를 가지고 RandomLineCreateStrategy를 생성한다")
    @Test
    void should_make_instance() {
        //arrange, act, assert
        assertThat(RandomLineCreateStrategy.of(new Random())).isInstanceOf(RandomLineCreateStrategy.class);
    }

    @DisplayName("랜덤 객체가 null 일 경우 IllegalArgumentException이 발생한다")
    @Test
    void throw_exception_when_random_is_null() {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> RandomLineCreateStrategy.of(null));
    }

    @DisplayName("랜덤 객체값을 그대로 리턴한다")
    @MethodSource
    @ParameterizedTest
    void should_return_value_using_random_value(Random random, boolean expectedValue) {
        //arrange
        RandomLineCreateStrategy randomGenerateStrategy = RandomLineCreateStrategy.of(random);

        //act, assert
        assertThat(randomGenerateStrategy.isCreatable()).isEqualTo(expectedValue);
    }

    private static Stream<Arguments> should_return_value_using_random_value() {
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