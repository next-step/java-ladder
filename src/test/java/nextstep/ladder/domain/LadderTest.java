package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        List<String> people = Arrays.asList("pobi", "honux", "crong", "jk");
        int height = 5;

        Ladder ladder = new Ladder(people, height);
        assertThat(ladder.coordinate().size()).isEqualTo(height);
    }
}
