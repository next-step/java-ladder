package nextstep.ladder.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("랜덤 발판 생성 전략 클래스 테스트")
class RandomStepGenerateStrategyTest {

    @DisplayName("랜덤 객체를 가지고 초기화한다")
    @Test
    void init() {
        assertThat(RandomStepGenerateStrategy.init(new Random())).isInstanceOf(RandomStepGenerateStrategy.class);
    }

    @DisplayName("랜덤 객체가 null 일 경우 예외를 발생 시킨다")
    @Test
    void initException() {
        assertThatThrownBy(() -> RandomStepGenerateStrategy.init(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
