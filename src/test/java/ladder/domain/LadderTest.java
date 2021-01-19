package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladder;


    @Test
    void ladderParticipateNames() {
        String names = "morr,dani";
        ladder = new Ladder(names);
        String[] split = names.split(",");

        List<Name> participateNames = ladder.participateNames(names);

        assertThat(participateNames).hasSize(split.length);

    }

    @Test
    void generateLadderLine() {
        String names = "morr,dani,dell";
        int ladderHeight = 4;
        ladder = new Ladder(names);

        List<Line> lines = ladder.generateLadderLine(4);

        assertThat(lines).hasSize(ladderHeight);
    }
}