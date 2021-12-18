package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {

    @Test
    void 사다리_생성() {
        // given
        int ladderHeight = 3;
        int numberOfParticipant = 4;
        LadderGenerator ladderGenerator = new LadderGenerator(() -> true);

        // when
        Ladder ladder = ladderGenerator.generate(ladderHeight, numberOfParticipant);

        // then
        LineGenerator lineGenerator = new LineGenerator();

        List<HorizontalLine> lines = new ArrayList<>();
        lines.add(lineGenerator.generate(numberOfParticipant, () -> true));
        lines.add(lineGenerator.generate(numberOfParticipant, () -> true));
        lines.add(lineGenerator.generate(numberOfParticipant, () -> true));

        Ladder expectedLadder = new Ladder(lines, numberOfParticipant);

        assertThat(ladder).isEqualTo(expectedLadder);
    }
}