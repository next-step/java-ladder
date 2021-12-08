package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import step4.strategy.RandomPointCreateStrategy;

public class LadderLineTest {

    @RepeatedTest(10)
    void 랜덤_생성_전략으로_사다리_라인을_생성한다() {
        //given
        LadderLine ladderLine = LadderLine.of(Width.of(4), new RandomPointCreateStrategy());
        //when
        for (Point point : ladderLine.lines()) {
            System.out.println(point.toString());
        }
        //then
        Assertions.assertThat(ladderLine.size()).isEqualTo(4);
    }
}
