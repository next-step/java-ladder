package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static nextstep.ladder.CommonConstans.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {


    private static StringBuffer stringLine = new StringBuffer();

    @Test
    @DisplayName("사다리게임플레이어시작포인트를벗어나면예외처리를한다")
    void overStartPointException() {
        LadderGame executeLadderGame = LadderGame.of("test1,test2,test3,test4");

        assertThatThrownBy(
                () -> executeLadderGame.checkPlayPoint(5)
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("사다리게임결과테스트")
    void resultLadderGameTest() {
        LadderGame executeLadderGame = LadderGame.of("test1,test2,test3,test4");
        executeLadderGame.setLadders(5);

        for (int i = 0; i < 4; i++) {
            System.out.print(executeLadderGame.getPlayers().get(i).getPlayer() + ONE_BLANK_SPACE);
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            drawLadderLine(4, executeLadderGame.getladders().get(i));
        }
        System.out.print(stringLine);


        Reward rewards = Reward.of("500000,400000,꽝,꽝", 4);

        rewards.getRewardList().forEach(reward -> System.out.print(reward + ONE_BLANK_SPACE));

        System.out.println("   ");

        System.out.println("test4의 결과");

        System.out.println(executeLadderGame.findPlayerReward(rewards.getRewardList(), "test4"));

        System.out.println("All 결과");

        for (int i = 0; i < executeLadderGame.getPlayers().size(); i++) {
            System.out.println(executeLadderGame.findPlayerReward(rewards.getRewardList(), executeLadderGame.getPlayers().get(i).getPlayer()));
        }

    }

    private static void drawLadderLine(int playerCount, Ladder ladder) {

        IntStream.range(NUMBER_ZERO, playerCount)
                .forEach(index -> createStringLine(ladder.getLines().get(index), index));
        stringLine.append("\n");
    }

    private static void createStringLine(boolean line, int index) {
        if (index == (4 - NUMBER_ONE)) {
            stringLine.append(FALSE_LINE);
            return;
        }

        if (line) {
            stringLine.append(TRUE_LINE);
            return;
        }
        stringLine.append(FALSE_LINE);
    }

}
