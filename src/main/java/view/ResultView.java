package view;

import domain.Ladder;
import domain.Participants;
import domain.RewardMap;
import domain.Rewards;

public class ResultView {

    public static void printLadder(Participants participants, Ladder ladder, Rewards rewards) {
        System.out.println("사다리 결과\n");
        System.out.println(participants.toString());
        System.out.println(ladder.toString());
        System.out.println(rewards.toString());
    }

    public static void printLadderGameResult(RewardMap rewardMap, String nameForReward) {
        System.out.println("실행 결과\n");
        System.out.println(rewardMap.viewResult(nameForReward));

    }
}
