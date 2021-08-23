package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.CommonConstans.ONE_BLANK_SPACE;

public class LadderGameTest {
    @Test
    @DisplayName("사다리 게임 테스트")
    void ladderGame() {
        LadderGame executeLadderGame = LadderGame.of("test1,test2,test3,test4", 5);

        executeLadderGame.getPlayers()
                .stream()
                .map(player -> player.getPlayer() + ONE_BLANK_SPACE)
                .forEach(System.out::print);

        System.out.println();

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
//
        System.out.println(rewards.getRewardResult().toString());
//
//        System.out.println(rewards.getRewardList().get(executeLadderGame.findPlayerReward("test3")));
//
//        for(int i=0; i < executeLadderGame.getPlayers().size(); i++){
//            System.out.print(rewards.getRewardList().get(rewards.getRewardResult().get(i)) + ONE_BLANK_SPACE);
//        }
//        RewardResult rewardResult = new RewardResult(ladders ,players);

    }

}
