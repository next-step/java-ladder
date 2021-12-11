package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Point;

import static nextstep.ladder.domain.Participant.PARTICIPANT_SIZE;

public class OutPut {
    private static final StringBuilder sb = new StringBuilder();

    public static void viewParticipants(Participants participants) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        participants.getParticipants().stream()
                .forEach(participant -> {
                    sb.setLength(0);
                    for (int i = 0; i < (PARTICIPANT_SIZE + 1 - participant.getParticipantLength()); i++) {
                        sb.append(" ");
                    }
                    System.out.print(participant.getParticipant() + sb.toString());
                });
        System.out.println();
    }

    public static void viewLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.print("|");
            line.getPoints().forEach(point -> {
                if (point == Point.of(true)) {
                    System.out.print("-----|");
                }
                if (point == Point.of(false)) {
                    System.out.print("     |");
                }
            });
            System.out.println();
        }
    }
}

