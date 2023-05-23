package nextstep.ladder;

import java.util.List;
import nextstep.ladder.drawPolicy.AllDraw;
import nextstep.ladder.drawPolicy.NoDraw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    Ladder ladder;

    @BeforeEach
    void init(){
        ArrayList<LadderRow> ladderRowList = new ArrayList<>();

        LadderRow ladderRow1 = new LadderRow(5, new AllDraw());
        LadderRow ladderRow2 = new LadderRow(5, new NoDraw());
        LadderRow ladderRow3 = new LadderRow(5, new NoDraw());
        LadderRow ladderRow4 = new LadderRow(5, new AllDraw());

        ladderRowList.add(ladderRow1);
        ladderRowList.add(ladderRow2);
        ladderRowList.add(ladderRow3);
        ladderRowList.add(ladderRow4);

        ladder = new Ladder(ladderRowList);
    }

    @Test
    void getLadder() {
        var actualLadder = ladder.getLadder();
        var expectLadder = List.of(new LadderRow(5, new AllDraw()),
                new LadderRow(5, new NoDraw()),
                new LadderRow(5, new NoDraw()),
                new LadderRow(5, new AllDraw())
                );

        assertThat(actualLadder).isEqualTo(expectLadder);
    }
}