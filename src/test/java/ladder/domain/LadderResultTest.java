package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    Ladder ladder;
    LadderResult ladderResult;
    List<Lines> linesList;
    Names names;

    @BeforeEach
    void setUp() {
        names = Names.of("a,b,c,d");
        linesList = new ArrayList<>();
        linesList.add(Lines.of(() -> Arrays.asList(false, true, false, true)));
        linesList.add(Lines.of(() -> Arrays.asList(false, false, true, false)));
        ladder = Ladder.of(linesList);
        ladderResult = new LadderResult(ladder, names);
    }

    @Test
    @DisplayName("result 메서드를 통해 특정 인덱스의 사다리 결과를 반환한다")
    void result() {
        assertThat(ladderResult.result(0)).isEqualTo(2);
        assertThat(ladderResult.result(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("resultOf 메서드를 통해 특정 이름의 사다리 결과를 반환한다")
    void resultOf() {
        assertThat(ladderResult.resultOf("a")).isEqualTo(2);
        assertThat(ladderResult.resultOf("b")).isEqualTo(0);
    }
}
