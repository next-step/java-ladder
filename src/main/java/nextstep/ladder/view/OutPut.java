package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

public class OutPut {


    public static void viewParticipants(Participants participants) {
        System.out.println("");
        System.out.println("실행결과");
        System.out.println("");
        participants.getParticipants().stream()
                .forEach(participant -> {
                    String temp = "";
                    for (int i = 0; i < (6 - participant.getParticipantLength()); i++) {
                        temp += " ";
                    }
                    System.out.print(participant.getParticipant() + temp);
                });
        System.out.println("");
    }

    public static void viewLadder(Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print("|");
            line.getPoints().stream().forEach(point -> {
                if (point == true) {
                    System.out.print("-----|");
                }
                if (point == false) {
                    System.out.print("     |");
                }
            });
            System.out.println("");
        }
    }
}

