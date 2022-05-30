package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LadderTest {
    public static Ladder ladder = new Ladder(Arrays.asList(LineTest.line1, LineTest.line2));

    @Test
    void move() {
        List<String> names = Arrays.asList("a", "b", "c", "d");
        Assertions.assertThat(ladder.extractIndexes(names.size())).isEqualTo(Arrays.asList(2, 0, 3, 1));
    }
}
