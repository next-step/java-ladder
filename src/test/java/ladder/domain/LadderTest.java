package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void Ladder_creation_test() {
        String names = "pobi,honux,crong,jk";
        String strHeight = "5";

        Participants participants = Participants.of(names);
        Height height = Height.of(strHeight);
        Ladder ladder = Ladder.of(participants, height);

        assertThat(height.equals(ladder.getLines().size())).isTrue();
    }

}
