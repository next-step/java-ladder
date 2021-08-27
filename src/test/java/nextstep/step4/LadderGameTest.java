package nextstep.step4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class LadderGameTest {

    @Test
    public void ladderGameTest() {

        List<LadderLine> ladderLines = Arrays.asList(LadderLine.init(3), LadderLine.init(3), LadderLine.init(3));

        LadderGame ladderGame = LadderGame.of(3, ladderLines);

        System.out.println(ladderGame.drawLadderLines());

        ladderGame.playLadder();

        System.out.print(ladderGame.playLadder().getEndPoint(0) + "\t");
        System.out.print(ladderGame.playLadder().getEndPoint(1) + "\t");
        System.out.print(ladderGame.playLadder().getEndPoint(2));

    }


}
