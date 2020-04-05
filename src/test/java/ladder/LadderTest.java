package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadder(){
        Players players = new Players(Arrays.asList(Player.of("jojo"), Player.of("zozo"), Player.of("kiki")));
        Ladder ladder = new Ladder(players, 5);

        for (VerticalLine verticalLine : ladder.getVerticalLines().getVerticalLines()) {
            System.out.println(verticalLine.getLineNo() + "번");
            for (Point point : verticalLine.getPoints()) {
                System.out.println("point " + point.getHeightPosition());
            }
            System.out.println("/////////////////////////////");
        }
    }
}
