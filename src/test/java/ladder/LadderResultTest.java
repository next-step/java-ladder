package ladder;

import ladder.domain.*;
import ladder.fixture.FixedRowFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderResultTest {

    @Test
    @DisplayName("사다리 결과를 매칭할 수 있다")
    public void ladder_result() {
        assertThat(ladderResult())
            .extracting(LadderResult::result)
            .isEqualTo(Map.of(
                new Name("pobi"), new Result("꽝"),
                new Name("honux"), new Result("3등"),
                new Name("crong"), new Result("2등"),
                new Name("jk"), new Result("1등")
            ));
    }

    private LadderResult ladderResult() {
        Names names = new Names(Arrays.asList("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(5, 4, fixedRowFactory());
        Results results = new Results(Arrays.asList("꽝", "1등", "2등", "3등"));

        return new LadderResult(names, ladder, results);
    }

    private FixedRowFactory fixedRowFactory() {
        return new FixedRowFactory(Arrays.asList(
            Arrays.asList(true, false, true)
            , Arrays.asList(false, true, false)
            , Arrays.asList(true, false, false)
            , Arrays.asList(false, true, false)
            , Arrays.asList(true, false, true)));
    }

}
