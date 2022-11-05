package nextstep.refactoring;

import nextstep.ladder.TrueGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void create() {
        // 불제너레이터, 사람숫자
        Ladder ladder = new Ladder(5, 4, new TrueGenerator());
        assertThat(ladder).isNotNull();
    }

    @Test
    void execute() {
        Ladder ladder = new Ladder(5, 4, new TrueGenerator());
        List<LadderResult> ladderResults = ladder.execute();

        assertThat(ladderResults).isEqualTo(
                List.of(
                        new LadderResult(0, 1),
                        new LadderResult(1, 0),
                        new LadderResult(2, 3),
                        new LadderResult(3, 2)
                )
        );
    }


}
