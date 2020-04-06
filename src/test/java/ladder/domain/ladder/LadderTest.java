package ladder.domain.ladder;

import ladder.domain.Gamers;
import ladder.domain.dto.LadderResultDto;
import ladder.domain.ladder.maker.MakeLadderStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {

    private int height;
    private Ladder testLadder;

    @BeforeEach
    void setTestLadder() {
        height = 5;
        testLadder = Ladder.of(Gamers.ofComma("a,b,c"), MakeLadderStrategy.getRandomMaker(2, height));
    }

    @Test
    @DisplayName("라인 수 가져오는 테스트")
    void getLinesTest() {
        assertThat(testLadder.getLines())
                .hasSize(height);
    }

    @Test
    @DisplayName("사다리 결과 뽑는 테스트")
    void getResultTest() {
        Gamers gamers = Gamers.ofComma("a,b,c");
        Ladder ladder = Ladder.of(gamers, MakeLadderStrategy.getPassiveMaker(
                Line.of(false, true),
                Line.of(true, false)));
        LadderResult result = LadderResult.ofComma("1,2,3");

        LadderResultDto dto = ladder.getResult(result);

        assertThat(dto.getResult("a"))
                .isEqualTo("2");
        assertThat(dto.getResult("b"))
                .isEqualTo("3");
        assertThat(dto.getResult("c"))
                .isEqualTo("1");
    }
}
