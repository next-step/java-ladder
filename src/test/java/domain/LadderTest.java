package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;

    @Test
    void ofTest(){
        ladder = Ladder.init(3,3);
        assertThat(ladder.getLadder().size()).isEqualTo(3);
    }

}
