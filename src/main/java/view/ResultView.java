package view;

import domain.Ladder;
import domain.Participants;

public class ResultView {

    public static void printLadder(Participants participants, Ladder ladder, String rewards) {
        System.out.println("사다리 결과\n");
        System.out.println(participants.toString());
        System.out.println(ladder.toString());
        System.out.println(rewards);
    }
}
