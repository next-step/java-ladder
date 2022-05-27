package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderTest {
    public static Ladder ladder = new Ladder(Arrays.asList(LineTest.line1, LineTest.line2));

    @Test
    void move() {
        List<String> names = Arrays.asList("a", "b", "c", "d");
        Assertions.assertThat(ladder.resultIndexes(names.size())).isEqualTo(Arrays.asList(2, 0, 3, 1));
    }
}
