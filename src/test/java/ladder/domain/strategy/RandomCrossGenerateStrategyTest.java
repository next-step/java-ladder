package ladder.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomCrossGenerateStrategyTest {

    @DisplayName("RandomCrossGenerate 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        RandomCrossGenerateStrategy strategy = RandomCrossGenerateStrategy.getInstance();

        // then
        assertThat(strategy).isNotNull();
    }

    @DisplayName("RandomCrossGenerate 인스턴스가 boolean 타입 반환하는지 테스트")
    @Test
    void 반환_타입() {
        // when
        RandomCrossGenerateStrategy strategy = RandomCrossGenerateStrategy.getInstance();

        // then
        assertThat(strategy.generate()).isInstanceOf(Boolean.class);
    }
}