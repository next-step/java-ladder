package ladder.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomLineGenerateStrategyTest {

    @DisplayName("RandomLineGenerateStrategy 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        RandomLineGenerateStrategy randomLineGenerateStrategy = RandomLineGenerateStrategy.getInstance();

        // then
        assertThat(randomLineGenerateStrategy).isNotNull();
    }

    @DisplayName("RandomLineGenerateStrategy 인스턴스 생성 여부 테스트")
    @Test
    void 반환() {
        // when
        RandomLineGenerateStrategy randomLineGenerateStrategy = RandomLineGenerateStrategy.getInstance();
        boolean actual = randomLineGenerateStrategy.generateLine();

        // then
        assertThat(randomLineGenerateStrategy.generateLine()).isInstanceOf(Boolean.class);
    }

}