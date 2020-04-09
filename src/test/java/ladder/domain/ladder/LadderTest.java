package ladder.domain.ladder;

import ladder.domain.Gamers;
import ladder.domain.ResultValues;
import ladder.domain.dto.LadderResultDto;
import ladder.domain.ladder.maker.RandomLadderMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ladder.domain.ladder.Bar.IS_EXIST;
import static ladder.domain.ladder.Bar.NOT_EXIST;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private int height;
    private Ladder testLadder;

    @BeforeEach
    void setTestLadder() {
        height = 5;
        testLadder = Ladder.of(Gamers.of(Arrays.asList("a","b","c")), RandomLadderMaker.of(2, height));
    }

    @Test
    @DisplayName("라인 수 가져오는 테스트")
    void getLinesTest() {
        assertThat(testLadder.getBarMatrix().getBarMatrix())
                .hasSize(height);
    }

    @Test
    @DisplayName("사다리 결과 뽑는 테스트")
    void getResultTest() {
        Gamers gamers = Gamers.of(Arrays.asList("a","b","c"));
        Ladder ladder = Ladder.of(gamers, () ->
                Arrays.asList(
                        Line.of(Arrays.asList(NOT_EXIST, IS_EXIST)),
                        Line.of(Arrays.asList(IS_EXIST, NOT_EXIST)))
        );
        ResultValues result = ResultValues.of(Arrays.asList("1","2","3"));

        LadderResultDto dto = ladder.getResult(result);

        assertThat(dto.getResult("a"))
                .isEqualTo("2");
        assertThat(dto.getResult("b"))
                .isEqualTo("3");
        assertThat(dto.getResult("c"))
                .isEqualTo("1");
    }
}
