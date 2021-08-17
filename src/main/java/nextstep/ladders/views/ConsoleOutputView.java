package nextstep.ladders.views;

import nextstep.ladders.domain.*;


public class ConsoleOutputView {

    public void print(Ladder ladder) {
        System.out.println("실행 결과");
        System.out.println();

        Participants participants = ladder.getParticipants();
        Lines lines = ladder.getLines();

        for (Participant participant : participants.getParticipants()) {
            printParticipant(participant);
        }
        System.out.println();
        for (Line line : lines.getLines()) {
            printLadder(line);
        }
    }

    private void printParticipant(Participant participant) {
        String name = participant.value();
        System.out.printf("%5s ", name);
    }

    private void printLadder(Line line) {
        for (Boolean point : line.getPoints()) {
            if (point) {
                System.out.print("-----|");
            } else {
                System.out.print("     |");
            }
        }
        System.out.println();
    }
}
