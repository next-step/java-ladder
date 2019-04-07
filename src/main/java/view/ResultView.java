package view;

import domain.Ladder;
import domain.Participants;

public class ResultView {
    public static void printLadders(Participants participants, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println(participants.toString());
        ladder.printLadder();
    }
}
