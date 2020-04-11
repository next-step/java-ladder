package ladder.domain;


import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class CrossRoadStrategyTest {

    @Test
    void moveStrategyTest() {
        CrossRoadStrategy crossRoadStrategy = () -> true;

        assertThat(crossRoadStrategy.movable()).isTrue();
    }
}
