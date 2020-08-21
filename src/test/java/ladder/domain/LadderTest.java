package ladder.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.core.line.LadderLineTestData;
import ladder.domain.core.line.Line;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {


    /*
       a     b     c
       |-----|     |
       |     |-----|
       |-----|     |
       1     2     3
    */
    private static final List<Line> ladderLines = LadderLineTestData.type01();

    @DisplayName("사다리 각 라인 상태를 다음 라인으로 정상적으로 전의 확인")
    @Test
    void ladderStatefulOperationTest() {
        LadderStatefulOperation s = new LadderStatefulOperation(ladderLines);
        String result = s.prepar("a").result(Line::getResult);
        assertThat(result).isEqualTo("3");
    }

    @DisplayName("사다리의 기능이 정상적으로 동작하는 지 확인")
    @Test
    void ladderTest(){
        Ladder ladder = new Ladder(ladderLines);
        String ride = ladder.ride("a");
        assertThat(ride).isEqualTo("3");
        assertThat(ladder.toDisplay()).isEqualTo(
            "     a     b     c\n" +
            "     |-----|     |     \n" +
            "     |     |-----|     \n" +
            "     |-----|     |     \n" +
            "     1     2     3"
        );

    }

}