package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

import static nextstep.ladder.domain.Participant.PARTICIPANT_SIZE;

public class OutPut {
    private static StringBuilder sb = new StringBuilder();


    public static void viewParticipants(Participants participants) {
        System.out.println("");
        System.out.println("실행결과");
        System.out.println("");
        participants.getParticipants().stream()
                .forEach(participant -> {
                    sb.setLength(0);
                    for (int i = 0; i < (PARTICIPANT_SIZE + 1 - participant.getParticipantLength()); i++) {
                        sb.append(" ");
                    }
                    System.out.print(participant.getParticipant() + sb.toString());
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

