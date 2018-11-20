package view;

import domain.Ladder;
import domain.Participants;

public class ResultView {
    public static void printLadder(Participants participants, Ladder ladder) {
        System.out.println("실행결과\n");
        System.out.println(participants.toString());
        System.out.println(ladder.toString());
    }
}
