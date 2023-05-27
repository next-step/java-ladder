package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_준비() {
        Players players = Players.create(FixtureForTest.namesFixture("pobi,honux,crong,jkkk"));
        Ladder ladder = new Ladder(players, 5);
        assertThat(ladder.getHeight()).isEqualTo(new LadderHeight(5));
    }

    @Test
    void 사다리_생성() {
        Players players = Players.create(FixtureForTest.namesFixture("pobi,honux,crong,jkkk"));
        Ladder ladder = new Ladder(players, 5);
        ladder.operate();
        assertAll(
                () -> assertThat(ladder.getLines()).isNotNull(),
                () -> assertThat(ladder.getLines()).hasSize(5)
        );


    }
}
