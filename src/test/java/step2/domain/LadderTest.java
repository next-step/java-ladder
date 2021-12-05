package step2.domain;

import org.junit.jupiter.api.Test;
import step2.strategy.RandomLineCreateStrategy;
import step2.view.ResultView;

import java.util.List;

class LadderTest {

    @Test
    void 사다리를_생성한다() {
        //given
        Ladder ladder = Ladder.create(LadderInfo.of(5, 5), new RandomLineCreateStrategy());
        //when
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            for (Boolean isLine : line.getLine()) {
                System.out.print(isLine + " ");
            }
            System.out.println();
        }
        System.out.println("---");
        //then
        ResultView.showResult(Participants.of("a,b,c,d,c"), ladder, Rewards.of("꽝,100,꽝,200,꽝"));
    }

}
