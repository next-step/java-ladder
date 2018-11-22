package view;

import domain.Ladder;
import domain.LadderResult;
import domain.Participants;
import domain.Rewards;

public class ResultView {

    public static void printLadder(Participants participants, Ladder ladder, Rewards rewards) {
        System.out.println("실행 결과\n");
        System.out.println(participants.toString());
        System.out.println(ladder.toString());
        System.out.println(rewards.toString());
    }

    public static void printLadderGameResult(LadderResult result, String name) {
        System.out.println("실행 결과\n");
        System.out.println(result.viewResult(name));
    }
}
