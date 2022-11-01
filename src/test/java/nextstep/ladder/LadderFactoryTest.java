package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {

    @Test
    void ladder_생성() {
        LadderFactory ladderFactory = new RandomLadderFactory();
        Ladder ladder = ladderFactory.creatLadder(5, 4);
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }
}
