package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLineGeneratorTest {
    @Test
    @DisplayName("주어진 길이만큼의 List<Boolean> 이 반환된다")
    void constructor() {
        int lineQuantity = 5;
        RandomLineGenerator randomLineGenerator = new RandomLineGenerator(lineQuantity);
        assertThat(randomLineGenerator.getLineBase().size()).isEqualTo(lineQuantity);
    }
}
