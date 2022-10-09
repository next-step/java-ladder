package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineFactoryTest {

    @DisplayName("personCount - 1 와 라인의 bridges 수가 일치한다")
    @Test
    void create() {
        int personCount = 4;
        RandomLineFactory randomLineFactory = new RandomLineFactory();
        Line line = randomLineFactory.create(personCount);

        assertThat(line.bridges()).hasSize(personCount - 1);
    }
}
