package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderResultTest {
    List<Lines> linesList;

    @BeforeEach
    void setUp() {
        linesList = new ArrayList<>();
        linesList.add(Lines.of(() -> Arrays.asList(false, true, false, true)));
        linesList.add(Lines.of(() -> Arrays.asList(false, false, true, false)));
    }

    @Test
    @DisplayName("Ladder 를 통해 LadderResult 가 생성된다")
    void name() {
        Ladder ladder = Ladder.of(linesList);
        LadderResult ladderResult = new LadderResult(ladder);
    }
}
