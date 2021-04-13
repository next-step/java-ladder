package ladder.strategy;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.strategy.UserBuilder;
import nextstep.ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserBuilderTest {
    @Test
    @DisplayName("미리 입력한 곳에 사다리 만들기")
    void createLadderPreDefined() {
        List<String> predefined = Arrays.asList("0,2", "1", "0", "1", "0,2");
        Ladder ladder = new Ladder(2, 4, new UserBuilder(predefined));

        ResultView.printResult(ladder.build(), 4);
    }
}
