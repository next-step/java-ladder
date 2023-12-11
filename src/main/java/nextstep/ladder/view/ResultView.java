package nextstep.ladder.view;

import nextstep.ladder.domain.Participants;

public class ResultView {
    private ResultView() {
    }

    public static void printResultWord() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printParticipantsName(Participants participants) {
        participants.getParticipants().forEach(participant -> System.out.print(String.format("%5s", participant.getName())));
    }
}
