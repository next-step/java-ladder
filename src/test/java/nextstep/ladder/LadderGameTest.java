package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static nextstep.ladder.CommonConstans.ONE_BLANK_SPACE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    @Test
    void 사다리게임플레이어시작포인트를벗어나면예외처리를한다() {
        LadderGame executeLadderGame = LadderGame.of("test1,test2,test3,test4", 5);

        assertThatThrownBy(
                () -> executeLadderGame.checkPlayPointAndRow(5, 5)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사다리게임에서사다리높이보다높은값을입력하면예외처리발생() {
        LadderGame executeLadderGame = LadderGame.of("test1,test2,test3,test4", 5);

        assertThatThrownBy(
                () -> executeLadderGame.checkPlayPointAndRow(4, 6)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력되지않는유저를찾을시예외를반환한다() {
        LadderGame executeLadderGame = LadderGame.of("test1,test2,test3,test4", 5);

        assertThatThrownBy(
                () -> executeLadderGame.findPlayerReward("test6")
        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 사다리게임결과테스트() {
        LadderGame executeLadderGame = LadderGame.of("test1,test2,test3,test4", 5);


        for (int i = 0; i < 4; i++) {
            System.out.print(executeLadderGame.getPlayers().get(i).getPlayer() + ONE_BLANK_SPACE);
        }

        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.println(executeLadderGame.getladders().get(i).getLines());
        }


        Reward rewards = Reward.of(4);

        rewards.getRewardList().forEach(reward -> System.out.print(reward + ONE_BLANK_SPACE));

        System.out.println("   ");

        for (int i = 0; i < executeLadderGame.getPlayers().size(); i++) {
            rewards.setPlayerList(executeLadderGame.getResultPoint(i, 0));
        }

        System.out.println(executeLadderGame.findPlayerReward("test5"));
        System.out.println(rewards.getRewardList().get(executeLadderGame.findPlayerReward("test5")));

        for (int i = 0; i < executeLadderGame.getPlayers().size(); i++) {
            System.out.print(rewards.getRewardList().get(rewards.getRewardResult().get(i)) + ONE_BLANK_SPACE);
        }

    }

}
