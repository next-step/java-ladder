package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    List<Lines> linesList;
    Names names;

    @BeforeEach
    void setUp() {
        names = Names.of("a,b,c,d");
        linesList = new ArrayList<>();
        linesList.add(Lines.of(() -> Arrays.asList(false, true, false, true)));
        linesList.add(Lines.of(() -> Arrays.asList(false, false, true, false)));
    }

    @Test
    @DisplayName("result 메서드를 통해 특정 인덱스의 사다리 결과를 반환한다")
    void result() {
        Ladder ladder = Ladder.of(linesList);
        LadderResult ladderResult = new LadderResult(ladder, names);
        assertThat(ladderResult.result(0)).isEqualTo(2);
        assertThat(ladderResult.result(1)).isEqualTo(0);
    }
}
