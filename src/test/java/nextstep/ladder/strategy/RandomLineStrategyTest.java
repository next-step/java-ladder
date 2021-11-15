package nextstep.ladder.strategy;

import nextstep.ladder.strategy.RandomLineStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineStrategyTest {
    RandomLineStrategy randomLineStrategy;

    @BeforeEach
    void setup() {
        randomLineStrategy = new RandomLineStrategy();
    }

    @Test
    @DisplayName("사람 수 만큼 지점 생성 검증")
    void createPoints() {
        int countOfPerson = 4;
        List<Boolean> points = randomLineStrategy.createPoints(countOfPerson);

        assertThat(points.size()).isEqualTo(countOfPerson);
    }
}
