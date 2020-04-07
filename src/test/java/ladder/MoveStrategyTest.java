package ladder;


import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class MoveStrategyTest {

    @Test
    void moveStrategyTest() {
        MoveStrategy moveStrategy = () -> true;

        assertThat(moveStrategy.movable()).isTrue();
    }
}
