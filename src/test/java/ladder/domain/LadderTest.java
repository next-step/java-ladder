package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setup(){
        ladder = new Ladder();
    }

    @Test
    void ladderParticipateNames() {
        String names = "morr,dani";
        String[] split = names.split(",");

        List<Name> participateNames = ladder.participateNames(names);

        assertThat(participateNames).hasSize(split.length);

    }

    @Test
    void generateLadderLine() {
        String names = "morr,dani,dell";
        int ladderHeight = 4;
        ladder = new Ladder(names,ladderHeight);

        List<Line> lines = ladder.generateLadderLine();

        assertThat(lines).hasSize(ladderHeight);
    }
}