package nextstep.ladder;

import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.generator.LadderGenerator;
import nextstep.ladder.domain.ladder.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
    @Test
    public void 입력된갯수만큼_사다리를_생성한다() {
        int countOfPerson = 4;
        Height height = new Height(5);

        LadderGenerator ladderGenerator = new LadderGenerator();

        Ladder ladder = ladderGenerator.generateLadder(countOfPerson, height);
        for(Line line : ladder.values()) {
            System.out.println(line);
            assertThat(line.size()).isEqualTo(countOfPerson - 1);
        }

        assertThat(ladder.values()).hasSize(5);
    }
}
