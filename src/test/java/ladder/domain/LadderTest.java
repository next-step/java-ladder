package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리생성() {
        Players players = Players.create(FixtureForTest.namesFixture("pobi,honux,crong,jkkk"));
        Ladder ladder = Ladder.create(5,players);
        assertAll(
            () -> assertThat(ladder.getHeight()).isEqualTo(new LadderHeight(5)),
            () -> assertThat(ladder.getMaxLineCountEachRow()).isEqualTo(3)
        );
    }
}
