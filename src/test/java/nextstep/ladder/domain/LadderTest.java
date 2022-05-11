package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class LadderTest {

    private final List<String> names = Arrays.asList("pobi", "honux", "crong", "jk");
    private final int height = 5;

    private final ConnectPolicy randomPolicy = () -> new Random().nextBoolean();

    @Test
    void createTest_1() {
        Ladder ladder = Ladder.of(names, height, randomPolicy);

        assertThat(ladder.lineCount()).isEqualTo(names.size() + names.size()-1);
        assertThat(ladder.lineHeight()).isEqualTo(height);
        assertThat(ladder.getLineNames()).containsExactly("pobi", "honux", "crong", "jk");
    }

}