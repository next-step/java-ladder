package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class DifficultyTest {
    @Test
    public void findByText() {
        Difficulty difficulty = Difficulty.findByText("상");
        Assertions.assertThat(difficulty).isEqualTo(Difficulty.HIGH);
    }
}
