package nextstep.ladder;

import nextstep.ladder.domain.generator.LadderGenerator;
import nextstep.ladder.domain.generator.LineGenerator;
import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.view.ResultView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
    @Test
    public void 입력된갯수만큼_사다리를_생성한다() {
        int countOfPeople = 4;
        Height height = new Height(5);

        Ladder ladder = LadderGenerator.generateLadder(countOfPeople, height);
        for(Line line : ladder.values()) {
            System.out.println(ResultView.viewLine(line));
            assertThat(line.size()).isEqualTo(countOfPeople - 1);
        }

        assertThat(ladder.values()).hasSize(5);
    }

    @Test
    public void 사람수를_입력하면_사람수보다_하나작은_사다리가_만들어진다() {
        int countOfPeople = 10;
        Line line = LineGenerator.generateLine(countOfPeople);
        assertThat(line.size()).isEqualTo(countOfPeople - 1);
    }
}
