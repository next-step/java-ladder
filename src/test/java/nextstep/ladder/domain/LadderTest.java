package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LadderTest {

    private final List<String> names = Arrays.asList("pobi", "honux", "crong", "jk");
    private final List<String> results = Arrays.asList("꽝", "5000", "꽝", "3000");
    private final int height = 5;

    @Test
    void createTest_1() {
        Ladder ladder = Ladder.of(names, results, height);

        assertThat(ladder.lineCount()).isEqualTo(names.size());
        assertThat(ladder.lineHeight()).isEqualTo(height);
        assertThat(ladder.getLineNames()).containsExactly("pobi", "honux", "crong", "jk");
        assertThat(ladder.getResults()).containsExactly("꽝", "5000", "꽝", "3000");
    }

}