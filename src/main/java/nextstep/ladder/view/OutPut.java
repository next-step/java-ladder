package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.HashMap;

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
                    System.out.print(participant.getParticipant() + sb);
                });
        System.out.println();
    }

    public static void viewLine(Line line) {
        for (Point point : line.getPoints()) {
            if (point == Point.of("right")) {
                System.out.print("|-----");
            }
            if (point != Point.of("right")) {
                System.out.print("|     ");
            }
        }
        System.out.println();
    }

    public static void viewLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            viewLine(line);
        }
    }

    public static void viewCompensation(Compensations compensations) {
        compensations.getCompensations().stream()
                .forEach(compensation -> {
                    sb.setLength(0);
                    for (int i = 0; i < (PARTICIPANT_SIZE + 1 - compensation.length()); i++) {
                        sb.append(" ");
                    }
                    System.out.print(compensation + sb);
                });
        System.out.println();
    }

    public static void viewResult(Participants participants, Compensations compensations, Ladder ladder, Participant participantWantResult) {
        HashMap<String, String> result = PlayGame.playGame(participantWantResult, participants, compensations, ladder);
        for (Participant participant : participants.getParticipants()) {
            if (result.containsKey(participant.getParticipant())) {
                System.out.println(participant.getParticipant() + " : " + result.get(participant.getParticipant()));
            }

        }
    }
}

