package ladder.domain;

import ladder.strategy.RandomMovingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {
    @DisplayName("랜덤하게 선이 추가된 사다리 높이 한 층(Floor)을 생성한다.")
    @Test
    void createWithRandomMovingStrategy() {
        int countOfPillar = 6;
        Floor floor = new Floor(countOfPillar, new RandomMovingStrategy(0)); // RandomMovingStrategyTest 참조 : true, true, false, true...
        assertThat(floor.getLines()).hasSize(countOfPillar);
        assertThat(floor.getLines().get(0)).isInstanceOf(Boolean.class);
        assertThat(floor.getLines()).containsExactly(false,true,false,true,false,false); // 홀수 인덱스 순서 true, true, false
    }

    @DisplayName("라인이 겹치는 경우는 존재하지 않는다.(= true가 2번 이상 연속하지 않는다.)")
    @Test
    void createConstraint() {
        int countOfPillar = 100;
        Floor floor = new Floor(countOfPillar, new RandomMovingStrategy());
        assertThat(floor.getLines()).doesNotContainSequence(true,true); // 라인이 겹치는 경우는 존재하지 않는다.(= true가 2번 이상 연속하지 않는다.)
    }

    @DisplayName("항상 true 전략을 가지는 사다리 한 층의 홀수 인덱스는 항상 true이다.")
    @Test
    void createWithAlwaysMovingStrategy() {
        int countOfPillar = 100;
        Floor floor = new Floor(countOfPillar, () -> true);
        IntStream.range(0,countOfPillar).filter(i -> i % 2 != 0).forEach(i -> assertThat(floor.getLines().get(i)).isTrue());
    }
}
