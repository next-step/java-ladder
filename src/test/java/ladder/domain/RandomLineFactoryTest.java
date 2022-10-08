package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineFactoryTest {

    @DisplayName("파라미터 laneCount 와 라인의 lane 수가 일치한다")
    @Test
    void create() {
        RandomLineFactory randomLineFactory = new RandomLineFactory();
        Line line = randomLineFactory.create(4);

        assertThat(line.lanes()).hasSize(4);
    }
}