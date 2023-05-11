package ladder.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.*;

@DisplayName("랜덤 사다리 전략 테스트")
class RandomLadderStrategyTest {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private LadderStrategy ladderStrategy;

    @BeforeEach
    public void setUp() {
        ladderStrategy = new RandomLadderStrategy(random);
    }

    @DisplayName("랜덤 전략 생성자에 null 은 전달 할 수 없다")
    @Test
    void randomLadderStrategyConstructorTest() {
        Assertions.assertThatNullPointerException()
                .isThrownBy(() -> new RandomLadderStrategy((BooleanSupplier) null))
                .withMessage("랜덤 전략 생성자에 null 을 전달 할 수 없습니다");
    }

    @DisplayName("사다리의 라인의 첫번째 선은 랜덤하게 생성된다")
    @Test
    void firstLineTest() {
        assertThat(ladderStrategy.firstLine()).isIn(true, false);
    }

    @DisplayName("이전 사다리가 있는 경우, 다음 사다리는 생성되지 않는다")
    @Test
    void nextLineTestWhenPreviousLineExists() {
        assertThat(ladderStrategy.nextLine(true)).isFalse();
    }

    @DisplayName("이전 사다리가 선이 없는 경우, 다음 사다리는 랜덤하게 생성된다")
    @Test
    void nextLineTestWhenPreviousLineDoesNotExist() {
        assertThat(ladderStrategy.nextLine(false)).isIn(true, false);
    }
}

