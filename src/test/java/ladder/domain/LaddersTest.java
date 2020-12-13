package ladder.domain;

import ladder.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class LaddersTest {

    private Line line;

    @BeforeEach
    public void init(){

        List<Point> lineConnections = new ArrayList<>();
        lineConnections.add(new Point(0,Direction.of(false, true)));
        lineConnections.add(new Point(1,Direction.of(true,false)));
        lineConnections.add(new Point(2,Direction.of(false,false)));

        line = new Line(lineConnections);
    }

    @DisplayName("Ladders 생성 테스트")
    @Test
    void laddersConstructorTest(){


        Ladder ladder1 = new Ladder(line);
        Ladder ladder2 = new Ladder(line);

        List<Ladder> ladderList = new ArrayList<>();
        ladderList.add(ladder1);
        ladderList.add(ladder2);

        Ladders ladders = new Ladders(ladderList);


        assertThat(ladders.getLadders()).containsExactly(new Ladder(line), new Ladder(line));
    }

    @DisplayName("Ladders Climb 테스트")
    @Test
    void laddersClimbTest(){

        Ladder ladder1 = new Ladder(line);
        Ladder ladder2 = new Ladder(line);

        List<Ladder> ladderList = new ArrayList<>();
        ladderList.add(ladder1);
        ladderList.add(ladder2);

        Ladders ladders = new Ladders(ladderList);

        ResultView.showBuildResult(new LadderBuildResult(ladders
                , new Players(new String[]{"aaa","bbb", "ccc"}))
                , new Awards(new String[]{"aaa","bbb", "ccc"}));

        /*

          AAA   BBB    CCC
            |-----|      |
            |-----|      |
     결과  AAA   BBB    CCC
          */

        assertThat(ladders.climb(0)).isEqualTo(0);
        assertThat(ladders.climb(1)).isEqualTo(1);
        assertThat(ladders.climb(2)).isEqualTo(2);
    }
}
