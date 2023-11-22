package ladder;

import ladder.factory.RandomRowStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class RandomRowStrategyTest {

    @Test
    @DisplayName("row를 생성할 수 있다")
    public void row() {
        assertThat(new RandomRowStrategy().rows(5, 3)).hasSize(5);
    }

}
