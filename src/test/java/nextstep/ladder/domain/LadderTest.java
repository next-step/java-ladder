package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        People people = new People(new String[]{"pobi", "honux", "crong", "jk"});
        ExecuteResults executeResults = new ExecuteResults(new String[]{"꽝", "5000", "꽝", "3000"});
        int height = 5;

        Ladder ladder = new Ladder(people, executeResults, height);
        assertThat(ladder.lines().value().size()).isEqualTo(height);

    }
}
