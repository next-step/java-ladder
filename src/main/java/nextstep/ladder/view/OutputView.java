package nextstep.ladder.view;

import nextstep.ladder.domain.Participants;

public class OutputView {
    private static final int SUBSTRING_INDEX = 1;

    public static void resultOutput(Participants participants) {
        System.out.println("실행결과");
        System.out.println();
        String participantsView = participants.toString()
                .substring(SUBSTRING_INDEX, participants.toString().length() - SUBSTRING_INDEX)
                .replace(",", "");
        System.out.println(participantsView);
    }

}
